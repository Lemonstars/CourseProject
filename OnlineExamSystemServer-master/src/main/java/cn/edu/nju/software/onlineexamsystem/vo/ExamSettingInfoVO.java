package cn.edu.nju.software.onlineexamsystem.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/09
 */
public class ExamSettingInfoVO {

    private Integer examSettingId;
    private String startTime;
    private String endTime;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ExamSettingInfoVO{" +
                "examSettingId=" + examSettingId +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
