package cn.edu.nju.software.onlineexamsystem.service;

import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperAfterExamVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */
public interface StatisticsService {

    /**
     * 根据科目生成成绩单
     * @param id
     * @return
     */
    XSSFWorkbook generateExamResult(Integer id);

    /**
     * 生成考后的试卷
     * @param email
     * @param subject
     * @return
     */
    PaperAfterExamVO generatePaperAfterExam(String email, String subject);

    /**
     * 获取所有的考试设置
     * @return
     */
    List<ExamSettingVO> getAllExamSetting();
}
