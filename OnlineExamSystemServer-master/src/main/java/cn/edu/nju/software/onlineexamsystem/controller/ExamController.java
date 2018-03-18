package cn.edu.nju.software.onlineexamsystem.controller;

import cn.edu.nju.software.onlineexamsystem.exception.ExceptionEnum;
import cn.edu.nju.software.onlineexamsystem.form.ExamGenerateForm;
import cn.edu.nju.software.onlineexamsystem.form.PaperForm;
import cn.edu.nju.software.onlineexamsystem.service.ExamService;
import cn.edu.nju.software.onlineexamsystem.service.QuestionService;
import cn.edu.nju.software.onlineexamsystem.util.ResponseUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ExamGenerateVO;
import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingInfoVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperVO;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */


@RestController
@RequestMapping(value="/exam")
@Api(value = "ExamController", description = "考试相关api")
public class ExamController {

    private static final int EXAM_PASSWORD_ERROR = -1;
    private static final int EXAM_TOO_EARLY = -2;
    private static final int EXAM_TOO_LATE = -3;

    @Autowired
    private ExamService examService;

    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "考试生成设置", notes = "设定科目、试题数、试题分值、起止时间、人员名单，时间格式如下：2017-10-12 15:34", httpMethod = "POST")
    @RequestMapping(value = "/setting", method = RequestMethod.POST)
    public ResponseVO generateExam(@RequestBody ExamGenerateForm examGenerateForm){

        List<String> allSubject = questionService.getAllSubject();
        if(allSubject.contains(examGenerateForm.getSubject())){
            examService.saveExamSetting(new ExamGenerateVO(examGenerateForm.getSubject(), examGenerateForm.getSingleOptionCount(),
                    examGenerateForm.getMultiplyOptionCount(), examGenerateForm.getPointPerSingleOption(), examGenerateForm.getPointPerMultiplyOption(),
                    examGenerateForm.getStartTime(), examGenerateForm.getEndTime(), examGenerateForm.getEmailList()));
            return ResponseUtil.success("success");
        }else {
            return ResponseUtil.error(ExceptionEnum.EXAM_SUBJECT_NOT_EXIST);
        }

    }

    @ApiOperation(value = "考试生成设置", notes = "设定科目、试题数、试题分值、起止时间、人员名单，考生名单通过excel的格式下载，时间格式如下：2017-10-12 15:34", httpMethod = "POST")
    @RequestMapping(value = "/settingByExcel", method = RequestMethod.POST)
    public ResponseVO generateExamByExcel(@RequestParam("studentSheet")MultipartFile file,
                                          @RequestParam("subject")String subject,
                                          @RequestParam("singleOptionCount")Integer singleOptionCount,
                                          @RequestParam("multiplyOptionCount")Integer multiplyOptionCount,
                                          @RequestParam("pointPerSingleOption")Integer pointPerSingleOption,
                                          @RequestParam("pointPerMultiplyOption")Integer pointPerMultiplyOption,
                                          @RequestParam("startTime")String startTime, @RequestParam("endTime")String endTime){
        List<String> allSubject = questionService.getAllSubject();
        if(allSubject.contains(subject)){
            examService.saveExamSettingByExcel(file, subject, singleOptionCount, multiplyOptionCount,
                    pointPerSingleOption, pointPerMultiplyOption, startTime, endTime);
            return ResponseUtil.success("success");
        }else {
            return ResponseUtil.error(ExceptionEnum.EXAM_SUBJECT_NOT_EXIST);
        }

    }

    @ApiOperation(value = "考生名单excel模版表格下载")
    @RequestMapping(value = "/sheet", method = RequestMethod.GET)
    public void downloadSheet(HttpServletResponse response) throws IOException{
        XSSFWorkbook xssfSheets =  examService.generateStudentSheet();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=sheet.xlsx");
        response.flushBuffer();
        xssfSheets.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


    @ApiOperation(value = "获取考卷", notes = "先根据返回码去判断请求是否正确：" +
            "密码错误返回码为3000，考试尚未开始返回码为3001，考试已经结束返回码为3002." +
            "注意：要encodeUrl", httpMethod = "GET")
    @RequestMapping(value = "/paper", method = RequestMethod.GET)
    public ResponseVO<PaperVO> generatePaper(@RequestParam("email")String email, @RequestParam("password")String password){
        ResponseVO responseVO;

        ExamSettingInfoVO vo = examService.validatePassword(email, password);
        int examSettingId =  vo.getExamSettingId();
        if(examSettingId == EXAM_PASSWORD_ERROR){
            responseVO = ResponseUtil.error(ExceptionEnum.EXAM_PASSWORD_ERROR);
        }else if(examSettingId == EXAM_TOO_EARLY){
            responseVO = ResponseUtil.error(ExceptionEnum.EXAM_TOO_EARLY);
        }else if(examSettingId == EXAM_TOO_LATE){
            responseVO = ResponseUtil.error(ExceptionEnum.EXAM_TOO_LATE);
        }else {
            PaperVO paperVO = examService.generatePaper(examSettingId, vo.getStartTime(), vo.getEndTime(), vo.getEmail());
            responseVO = ResponseUtil.success(paperVO);
        }

        return  responseVO;
    }

    @ApiOperation(value = "提交考卷", notes = "考试结束后提交考卷,多选题答案用ABCD表示，并用&隔开，例如:A&C&D")
    @RequestMapping(value = "/paper", method = RequestMethod.POST)
    public ResponseVO uploadPaper(@RequestBody PaperForm paperForm){
        examService.saveStudentExam(paperForm.getPaperId(), paperForm.getSingleOptionQuestionAnswers(), paperForm.getMultiplyOptionQuestionAnswers());
        return ResponseUtil.success();
    }

}
