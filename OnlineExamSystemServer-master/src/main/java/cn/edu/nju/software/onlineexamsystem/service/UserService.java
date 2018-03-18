package cn.edu.nju.software.onlineexamsystem.service;

import cn.edu.nju.software.onlineexamsystem.form.UserRegisterForm;
import cn.edu.nju.software.onlineexamsystem.vo.UserVO;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/05
 */
public interface UserService {


    /**
     * 检查账号密码是否正确
     * @param email
     * @param password
     * @return
     */
    boolean checkAccountValid(String email, String password);

    /**
     * 检查邮箱接受的验证码是否正确
     * @param userVO
     * @return
     */
    boolean checkRegisterCode(UserRegisterForm userVO);

    /**
     * 通过年级获取用户
     * @param grade
     * @return
     */
    List<UserVO> getByGrade(int grade);

    /**
     * 通过年级和班级获取用户
     * @param grade
     * @param classId
     * @return
     */
    List<UserVO> getByGradeAndClass(int grade, int classId);
}
