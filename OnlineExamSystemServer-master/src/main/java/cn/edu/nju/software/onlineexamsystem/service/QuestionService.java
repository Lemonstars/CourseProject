package cn.edu.nju.software.onlineexamsystem.service;

import cn.edu.nju.software.onlineexamsystem.vo.SubjectVO;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/16
 */
public interface QuestionService {

    /**
     * 生成单选题模版
     * @return
     */
    XSSFWorkbook createSingleOptionWorkBook();

    /**
     * 上传文件
     * @param subject
     * @param file
     * @return
     */
    boolean uploadFile(String subject, MultipartFile file);

    /**
     * 获取所有的试题科目
     * @return
     */
    List<String> getAllSubject();

    /**
     * 获取该科目下的试题数量
     * @param subjectName
     * @return
     */
    SubjectVO getSubjectQuestionCount(String subjectName);
}
