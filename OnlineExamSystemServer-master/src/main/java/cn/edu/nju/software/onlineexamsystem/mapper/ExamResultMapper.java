package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.ExamResultEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */
public interface ExamResultMapper {

    /**
     * 新增
     * @param entity
     */
    @Insert("insert into examResult(studentId, studentName, subject, " +
            "singleOptionQuestion, singleOptionStudentAnswer, singleOptionCorrectAnswer," +
            "multiplyOptionQuestion, multiplyOptionStudentAnswer, multiplyOptionCorrectAnswer, " +
            "pointPerSingleOptionQuestion, pointPerMultiplyOptionQuestion, sumPoint, studentPoint, email) " +
            "values( #{entity.studentId} ,#{entity.studentName} ,#{entity.subject}," +
            "#{entity.singleOptionQuestion} ,#{entity.singleOptionStudentAnswer} ,#{entity.singleOptionCorrectAnswer}, " +
            "#{entity.multiplyOptionQuestion} ,#{entity.multiplyOptionStudentAnswer} ,#{entity.multiplyOptionCorrectAnswer}, " +
            "#{entity.pointPerSingleOptionQuestion} ,#{entity.pointPerMultiplyOptionQuestion} " +
            ",#{entity.sumPoint} ,#{entity.studentPoint} ,#{entity.email})")
    void insert(@Param("entity") ExamResultEntity entity);

    /**
     * 通过考试科目查找所有考试结果
     * @param subject
     * @return
     */
    @Select("select * from examResult where subject = #{subject}")
    List<ExamResultEntity> findBySubject(@Param("subject")String subject);

    /**
     * 通过科目和email查找成绩
     * @param email
     * @param subject
     * @return
     */
    @Select("select * from examResult where email = #{email} and subject = #{subject}")
    ExamResultEntity findByEmailAndSubject(@Param("email")String email, @Param("subject")String subject);
}
