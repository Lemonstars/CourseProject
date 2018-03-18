package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.ExamSettingEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public interface ExamSettingMapper {

    /**
     * 新增考试设置
     * @param entity
     * @return
     */
    @Insert("insert into examSetting(subject, singleOptionCount, multiplyOptionCount," +
            "pointPerSingleOption, pointPerMultiplyOption)" +
            "values(#{entity.subject}, #{entity.singleOptionCount}, #{entity.multiplyOptionCount}, " +
            "#{entity.pointPerSingleOption}, #{entity.pointPerMultiplyOption})")
    @Options(useGeneratedKeys=true, keyProperty="entity.id")
    void addExamSetting(@Param("entity")ExamSettingEntity entity);

    /**
     * 通过id查找
     * @param id
     * @return
     */
    @Select("select * from examSetting where id = #{id}")
    ExamSettingEntity findById(@Param("id")Integer id);

    /**
     * 通过subject查找
     * @param subject
     * @return
     */
    @Select("select * from examSetting where subject = #{subject}")
    ExamSettingEntity findBySubject(@Param("subject")String subject);

    /**
     * 获取所有考试设置
     * @return
     */
    @Select("select * from examSetting")
    List<ExamSettingEntity> getAllExamSetting();

}
