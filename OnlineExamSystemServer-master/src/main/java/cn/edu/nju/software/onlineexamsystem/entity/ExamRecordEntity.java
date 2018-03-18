package cn.edu.nju.software.onlineexamsystem.entity;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public class ExamRecordEntity {

    private Integer id;
    private String email;
    private Integer examSettingId;
    private String startTime;
    private String endTime;
    private Integer password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getExamSettingId() {
        return examSettingId;
    }

    public void setExamSettingId(Integer examSettingId) {
        this.examSettingId = examSettingId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
