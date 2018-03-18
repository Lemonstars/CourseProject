package cn.edu.nju.software.onlineexamsystem.controller;

import cn.edu.nju.software.onlineexamsystem.exception.ExceptionEnum;
import cn.edu.nju.software.onlineexamsystem.form.UserRegisterForm;
import cn.edu.nju.software.onlineexamsystem.service.MailService;
import cn.edu.nju.software.onlineexamsystem.service.TokenService;
import cn.edu.nju.software.onlineexamsystem.service.UserService;
import cn.edu.nju.software.onlineexamsystem.util.ResponseUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import cn.edu.nju.software.onlineexamsystem.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户Controller
 *
 * @author 刘兴
 * @date 2017/10/29
 */
@RestController
@RequestMapping(value="/user")
@Api(value = "UserController", description = "用户相关api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private MailService mailService;

    @ApiOperation(value = "登录", notes = "登录", httpMethod = "POST")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseVO login(@RequestParam("email")String email, @RequestParam("password")String password){
        ResponseVO responseVO;
        boolean isValid = userService.checkAccountValid(email, password);
        if(isValid){
            String token = tokenService.generateToken(email);
            responseVO = ResponseUtil.success(token);
        }else {
            responseVO = ResponseUtil.error(ExceptionEnum.ACCOUNT_ERROR);
        }
        return responseVO;
    }

    @ApiOperation(value = "注册步骤1", notes = "提交email, 这个验证码有1分钟的时间限制，" +
            "建议在注册步骤一就填写好注册步骤2中的其他信息；在注册步骤2中只用填验证码", httpMethod = "POST")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVO register(@RequestParam("email")String email){
        ResponseVO responseVO;
        boolean isEmailRegistered = !mailService.sendRegisterEmail(email);
        if(isEmailRegistered){
            responseVO = ResponseUtil.error(ExceptionEnum.REGISTER_ERROR);
        }else {
            responseVO = ResponseUtil.success();
        }
        return responseVO;
    }

    @ApiOperation(value = "注册步骤2", notes = "邮箱接受的验证码及其他信息", httpMethod = "POST")
    @RequestMapping(value = "/registerCode", method = RequestMethod.POST)
    public ResponseVO confirmRegisterNum(@RequestBody UserRegisterForm userRegisterForm){
        ResponseVO responseVO;
        boolean isCorrectCode = userService.checkRegisterCode(userRegisterForm);
        if(isCorrectCode){
            responseVO = ResponseUtil.success();
        }else {
            responseVO = ResponseUtil.error(ExceptionEnum.REGISTER_CODE_ERROR);
        }
        return responseVO;
    }

    @ApiOperation(value = "通过年级获取学生列表", httpMethod = "GET")
    @RequestMapping(value = "/grade", method = RequestMethod.GET)
    public ResponseVO getUserByGrade(@RequestParam("grade")Integer grade){
        List<UserVO> userVOList = userService.getByGrade(grade);
        return ResponseUtil.success(userVOList);
    }

    @ApiOperation(value = "通过年级和班级获取学生列表", httpMethod = "GET")
    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public ResponseVO getUserByGradeAndClass(@RequestParam("grade")Integer grade, @RequestParam("class")Integer classId){
        List<UserVO> userVOList = userService.getByGradeAndClass(grade, classId);
        return ResponseUtil.success(userVOList);
    }

}