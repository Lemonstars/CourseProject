package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.entity.UserEntity;
import cn.edu.nju.software.onlineexamsystem.mapper.UserMapper;
import cn.edu.nju.software.onlineexamsystem.service.MailService;
import cn.edu.nju.software.onlineexamsystem.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author 刘兴
 * @date 2017/11/05
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserMapper userMapper;

    private static final String SENDER_EMAIL = "starrylemon@aliyun.com";

    /**
     * 邮件内容
     */
    private static String MAIL_TEXT = "在线考试系统验证码:";

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public boolean sendRegisterEmail(String email) {
        UserEntity userEntity = userMapper.findByEmail(email);
        if(userEntity != null){
            return false;
        }

        String confirmNum = RandomUtil.random();
        SimpleMailMessage message =new SimpleMailMessage();

        message.setFrom(SENDER_EMAIL);
        message.setTo(email);
        message.setSubject("在线考试系统邮件验证");
        message.setText(MAIL_TEXT + confirmNum);

        String emailRegisterCode = email + "-RegisterCode";
        stringRedisTemplate.opsForValue().set(emailRegisterCode, confirmNum);
        stringRedisTemplate.expire(emailRegisterCode, 90, TimeUnit.SECONDS);

        mailSender.send(message);
        return true;
    }


    @Override
    public boolean sendExamRemindEmail(String email, String startTime, String endTime, String subject, String enPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_EMAIL);
        message.setTo(email);
        message.setSubject("考试提醒");
        String emailContent = "【考试通知】请于"+startTime+"至"+endTime+"参加《"+subject+"》考试，本次考试的访问密码为:"+enPassword;
        message.setText(emailContent);

        mailSender.send(message);
        return true;
    }

    @Override
    public boolean sendExamResult(String email, String subject, int sumPoint, int studentPoint) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(SENDER_EMAIL);
        message.setTo(email);
        message.setSubject("考试成绩");
        String emailContent = "【考试成绩通知】你"+"参加的《"+subject+"》考试，"+"总分"
                +sumPoint+"分，你的成绩为"+studentPoint+"分";
        message.setText(emailContent);

        mailSender.send(message);

        return true;
    }
}
