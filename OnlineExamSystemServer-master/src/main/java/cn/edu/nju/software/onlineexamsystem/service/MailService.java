package cn.edu.nju.software.onlineexamsystem.service;

/**
 *
 *
 * @version 1.0
 * @author 刘兴
 * @date 2017/11/5
 */
public interface MailService {

    /**
     * 在注册时发送验证码到指定邮箱
     * @param email
     * @return
     */
    boolean sendRegisterEmail(String email);

    /**
     * 发送考试提醒邮件
     * @param email
     * @param startTime
     * @param endTime
     * @param subject
     * @param enPassword
     * @return
     */
    boolean sendExamRemindEmail(String email, String startTime, String endTime, String subject,String enPassword);

    /**
     * 发送考试成绩邮件
     * @param email
     * @param subject
     * @param sumPoint
     * @param studentPoint
     * @return
     */
    boolean sendExamResult(String email, String subject, int sumPoint, int studentPoint);
}
