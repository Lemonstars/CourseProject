package cn.edu.nju.software.onlineexamsystem.service;

import cn.edu.nju.software.onlineexamsystem.vo.ExamGenerateVO;
import cn.edu.nju.software.onlineexamsystem.vo.ExamSettingInfoVO;
import cn.edu.nju.software.onlineexamsystem.vo.PaperVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public interface ExamService {

    /**
     * 保存生成考试的设置
     * @param examGenerateVO
     */
    void saveExamSetting(ExamGenerateVO examGenerateVO);

    /**
     * 保存生成考试的设置，考生名单由excel生成
     * @param file
     * @param subject
     * @param singleOptionCount
     * @param multiplyOptionCount
     * @param pointPerSingleOption
     * @param pointPerMultiplyOption
     * @param startTime
     * @param endTime
     */
    void saveExamSettingByExcel(MultipartFile file,String subject, Integer singleOptionCount,
                                Integer multiplyOptionCount, Integer pointPerSingleOption,
                                Integer pointPerMultiplyOption, String startTime, String endTime);

    /**
     * 生成考生名单模版
     * @return
     */
    XSSFWorkbook generateStudentSheet();

    /**
     * 验证单次考试的用户名和密码是否匹配
     * @param email
     * @param enPassword
     * @return ExamSettingInfoVO.examSettingId:
     *         -1 密码错误;-2 考试尚未开始;-3 考试已经结束
     *         正确情况下返回examSettingId
     */
    ExamSettingInfoVO validatePassword(String email, String enPassword);

    /**
     * 生成试题数据
     * @param examSettingId
     * @param startTime
     * @param endTime
     * @param email
     * @return
     */
    PaperVO generatePaper(Integer examSettingId, String startTime, String endTime, String email);

    /**
     * 保存学生的考试试卷,并发送邮件告知成绩
     * @param paperId
     * @param singleOptionAnswers 单选题答案
     * @param multiplyOptionAnswers 多选题答案
     */
    void saveStudentExam(Integer paperId, List<String> singleOptionAnswers, List<String> multiplyOptionAnswers);

}
