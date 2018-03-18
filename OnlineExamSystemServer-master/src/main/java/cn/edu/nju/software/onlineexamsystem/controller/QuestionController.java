package cn.edu.nju.software.onlineexamsystem.controller;

import cn.edu.nju.software.onlineexamsystem.exception.ExceptionEnum;
import cn.edu.nju.software.onlineexamsystem.service.QuestionService;
import cn.edu.nju.software.onlineexamsystem.util.ResponseUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import cn.edu.nju.software.onlineexamsystem.vo.SubjectVO;
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
 * @date 2017/11/16
 */

@RestController
@RequestMapping(value="/question")
@Api(value = "QuestionController", description = "试题相关api")
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "试题模版", notes = " 试题模版下载", httpMethod = "GET")
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public void downloadTemplate(HttpServletResponse response) throws IOException{
        XSSFWorkbook xssfSheets = questionService.createSingleOptionWorkBook();
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=exam.xlsx");
        response.flushBuffer();
        xssfSheets.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }


    @ApiOperation(value = "试题上传", notes = "试题以excel文档的方式导入,这里的subject每次上传不可重复，重复会返回异常" +
            "我的设想是subject=数据结构2017秋这样的内容，而不是subject=数据结构", httpMethod = "POST")
    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public ResponseVO uploadQuestions(@RequestParam("subject")String subject, @RequestParam("file")MultipartFile file){
         ResponseVO responseVO;

         List<String> allSubject = questionService.getAllSubject();
         if(allSubject.contains(subject)){
             return ResponseUtil.error(ExceptionEnum.FILE_SUBJECT_EXIST_FAIL);
         }

         boolean uploadSuccess = questionService.uploadFile(subject, file);
         if(uploadSuccess){
             responseVO = ResponseUtil.success("success");
         }else {
             responseVO = ResponseUtil.error(ExceptionEnum.FILE_UPLOAD_FAIL);
         }
         return responseVO;
    }

    @ApiOperation(value = "获取试题科目列表", notes = "所有之前用excel上传的试题科目名称", httpMethod = "GET")
    @RequestMapping(value = "/subject", method = RequestMethod.GET)
    public ResponseVO getAllSubject(){
        List<String> allSubject = questionService.getAllSubject();
        ResponseVO responseVO = ResponseUtil.success(allSubject);

        return responseVO;
    }

    @ApiOperation(value = "获取该科目的试题类型和数量", notes = "题型有单选题和多选题，若数量为0，则表示无该类型。注意，由于科目可能为中文，需要对subject进行encodeUri", httpMethod = "GET")
    @RequestMapping(value = "/subject/{subjectName}", method = RequestMethod.GET)
    public ResponseVO getSubjectCount(@PathVariable("subjectName") String subjectName){
        SubjectVO subjectVO = questionService.getSubjectQuestionCount(subjectName);
        return ResponseUtil.success(subjectVO);
    }

}

