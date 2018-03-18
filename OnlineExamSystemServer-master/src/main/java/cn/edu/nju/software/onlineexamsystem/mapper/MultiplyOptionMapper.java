package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.MultiplyOptionEntity;
import cn.edu.nju.software.onlineexamsystem.entity.SingleOptionEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/02
 */
public interface MultiplyOptionMapper {

    /**
     * 添加试题
     * @param question
     * @param option1
     * @param option2
     * @param option3
     * @param option4
     * @param answer
     * @param subject
     */
    @Insert("insert into multiplyOption(question, option1, option2, option3, option4, answer, subject) " +
            "values(#{question}, #{option1}, #{option2}, #{option3}, #{option4}, #{answer}, #{subject}) ")
    void insertMultiplyOption(@Param("question")String question, @Param("option1")String option1, @Param("option2")String option2,
                    @Param("option3")String option3, @Param("option4")String option4, @Param("answer")String answer, @Param("subject")String subject);

    /**
     * 获取所有科目的名称
     * @return
     */
    @Select("select distinct subject from singleOption")
    List<String> getAllSubject();

    /**
     * 获取该科目的试题数量
     * @param subjectName
     * @return
     */
    @Select("select count(*) from multiplyOption where subject = #{subjectName}")
    int getSubjectQuestionCount(String subjectName);


    /**
     * 获取指定科目下的指定数量题目
     * @param subject
     * @param limit
     * @return
     */
    @Select("select * from multiplyOption where subject = #{subject} limit #{limit}")
    List<MultiplyOptionEntity> getBySubjectAndLimit(@Param("subject")String subject, @Param("limit")Integer limit);

    /**
     * 获取指定科目下的所有题目
     * @param subject
     * @return
     */
    @Select("select * from multiplyOption where subject = #{subject}")
    List<MultiplyOptionEntity> getBySubject(@Param("subject")String subject);

}
