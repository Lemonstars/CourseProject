package cn.edu.nju.software.onlineexamsystem.mapper;

import cn.edu.nju.software.onlineexamsystem.entity.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 刘兴
 * @date 2017/11/13
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 通过邮箱获取用户信息
     * @param email
     * @return
     */
    @Select("select * from user where email = #{email}")
    UserEntity findByEmail(@Param("email") String email);

    /**
     * 新增用户
     * @param name
     * @param studentId
     * @param email
     * @param gradeId
     * @param classId
     * @param password
     */
    @Insert("insert into user(name, studentId, email, gradeId, classId, password) " +
            "values(#{name}, #{studentId}, #{email}, #{gradeId}, #{classId}, #{password}) ")
    void insertUser(@Param("name")String name, @Param("studentId")String studentId, @Param("email")String email,
                    @Param("gradeId")int gradeId, @Param("classId")int classId, @Param("password")String password);

    /**
     * 通过年级获取用户
     * @param grade
     * @return
     */
    @Select("select * from user where gradeId = #{grade}")
    List<UserEntity> getByGrade(@Param("grade")int grade);

    /**
     * 通过年级和班级查找用户
     * @param grade
     * @param classId
     * @return
     */
    @Select("select * from user where gradeId = #{grade} and classId = #{class}")
    List<UserEntity> getByGradeAndClass(@Param("grade")int grade,@Param("class")int classId);

    /**
     * 获取所有的email
     * @return
     */
    @Select("select email from user")
    List<String> getAllEmails();

}