package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.ExamQuestionOrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/09
 */
public interface ExamQuestionOrderMapper {

    /**
     * 增加记录
     * @param entity
     */
    @Insert("insert into examQuestionOrder(email, singleOptionOrder, multiplyOptionOrder, examSettingId) " +
            "values(#{entity.email}, #{entity.singleOptionOrder}, #{entity.multiplyOptionOrder} ,#{entity.examSettingId})")
    @Options(useGeneratedKeys=true, keyProperty="entity.id")
    void insert(@Param("entity") ExamQuestionOrderEntity entity);

    /**
     * 通过id查找
     * @param id
     * @return
     */
    @Select("select * from examQuestionOrder where id = #{id}")
    ExamQuestionOrderEntity findById(@Param("id")Integer id);

}
