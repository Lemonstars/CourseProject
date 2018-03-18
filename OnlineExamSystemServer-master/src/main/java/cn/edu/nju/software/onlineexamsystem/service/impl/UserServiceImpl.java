package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.entity.UserEntity;
import cn.edu.nju.software.onlineexamsystem.mapper.UserMapper;
import cn.edu.nju.software.onlineexamsystem.service.UserService;
import cn.edu.nju.software.onlineexamsystem.form.UserRegisterForm;
import cn.edu.nju.software.onlineexamsystem.vo.UserVO;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/05
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private StringEncryptor stringEncryptor;

    @Override
    public boolean checkAccountValid(String email, String password) {
        if(password == null || password.equals("")){
            return false;
        }

        UserEntity userEntity = userMapper.findByEmail(email);
        if(userEntity == null){
            return  false;
        }

        String passwordEn = userEntity.getPassword();
        String passwordDe = stringEncryptor.decrypt(passwordEn);
        if(password.equals(passwordDe)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean checkRegisterCode(UserRegisterForm userVO) {
        String email = userVO.getEmail();
        String code = userVO.getRegisterCode();
        if(StringUtils.isEmpty(code)){
            return false;
        }

        String emailRegisterCode = email + "-RegisterCode";
        String redisCode = stringRedisTemplate.opsForValue().get(emailRegisterCode);
        if(code.equals(redisCode)){
            String passwordEn = stringEncryptor.encrypt(userVO.getPassword());
            userMapper.insertUser(userVO.getName(), userVO.getStudentId(), userVO.getEmail(),
                    userVO.getGradeId(), userVO.getClassId(), passwordEn);
            stringRedisTemplate.delete(emailRegisterCode);
            return true;
        }

        return false;
    }

    @Override
    public List<UserVO> getByGrade(int grade) {
        List<UserVO> res = new ArrayList<>();
        List<UserEntity> entityList = userMapper.getByGrade(grade);
        UserVO userVO;
        for(UserEntity entity: entityList){
            userVO = new UserVO(entity.getId(), entity.getName(), entity.getStudentId(),
                    entity.getEmail(), entity.getGradeId(), entity.getClassId());
            res.add(userVO);
        }
        return res;
    }

    @Override
    public List<UserVO> getByGradeAndClass(int grade, int classId) {
        List<UserVO> res = new ArrayList<>();
        List<UserEntity> entityList = userMapper.getByGradeAndClass(grade, classId);
        UserVO userVO;
        for(UserEntity entity: entityList){
            userVO = new UserVO(entity.getId(), entity.getName(), entity.getStudentId(),
                    entity.getEmail(), entity.getGradeId(), entity.getClassId());
            res.add(userVO);
        }
        return res;
    }
}
