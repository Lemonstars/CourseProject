package cn.edu.nju.software.onlineexamsystem.controller;

import cn.edu.nju.software.onlineexamsystem.service.StatisticsService;
import cn.edu.nju.software.onlineexamsystem.util.ResponseUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperAfterExamVO;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */

@RestController

@RequestMapping(value="/statistics")
@Api(value = "StatisticsController", description = "统计相关api")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;


    @ApiOperation(value = "生成考试成绩单", notes = "成绩单以excel的形式呈现,subject注意encodeUrl", httpMethod = "GET")
    @RequestMapping(value = "/result/{id}", method = RequestMethod.GET)
    public void generateExamResultExcel(HttpServletResponse response, @PathVariable("id")Integer id) throws IOException {
        XSSFWorkbook xssfSheets = statisticsService.generateExamResult(id);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=result.xlsx");
        response.flushBuffer();
        xssfSheets.write(response.getOutputStream());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    @ApiOperation(value = "获取所有考试设置", notes = "为了上面一个接口的id", httpMethod = "GET")
    @RequestMapping(value = "/examSetting", method = RequestMethod.GET)
    public ResponseVO getAllExamSetting(){
        List<ExamSettingVO> examSettingVOList = statisticsService.getAllExamSetting();
        return ResponseUtil.success(examSettingVOList);
    }


    @ApiOperation(value = "考后生成试卷", notes = "生成的试卷包含用户选择和答案", httpMethod = "GET")
    @RequestMapping(value = "/paper", method = RequestMethod.GET)
    public ResponseVO generatePaperAfterExam(@RequestParam("email")String email, @RequestParam("subject")String subject){
        PaperAfterExamVO vo = statisticsService.generatePaperAfterExam(email, subject);
        return ResponseUtil.success(vo);
    }

}
