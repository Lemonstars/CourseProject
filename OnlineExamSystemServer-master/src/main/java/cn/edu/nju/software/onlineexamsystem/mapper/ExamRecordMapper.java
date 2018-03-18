package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.ExamRecordEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public interface ExamRecordMapper {

    /**
     * 新增考试记录
     * @param email
     * @param examSettingId
     * @param startTime
     * @param endTime
     * @param password
     */
    @Insert("insert into examRecord(email, examSettingId, startTime, endTime, password) " +
            "values(#{email}, #{examSettingId}, #{startTime}, #{endTime}, #{password})")
    void addExam(@Param("email")String email, @Param("examSettingId")Integer examSettingId,
                 @Param("startTime")String startTime, @Param("endTime")String endTime, @Param("password")String password);


    /**
     * 通过邮箱和考试密码查询
     * @param email
     * @param password
     * @return
     */
    @Select("select * from examRecord where email = #{email} and password = #{password}")
    List<ExamRecordEntity> findByEmailAndPassword(@Param("email")String email, @Param("password")Integer password);

    /**
     * 通过考试设置表示查找所有参加这门考试的考生邮箱
     * @param examSettingId
     * @return
     */
    @Select("select email from examRecord where examSettingId = #{examSettingId}")
    List<String> findAllEmailsByExamSettingId(@Param("examSettingId")Integer examSettingId);

}
