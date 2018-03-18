package cn.edu.nju.software.onlineexamsystem.form;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public class ExamGenerateForm {

    private String subject;
    private Integer singleOptionCount;
    private Integer multiplyOptionCount;
    private Integer pointPerSingleOption;
    private Integer pointPerMultiplyOption;
    private String startTime;
    private String endTime;
    private List<String> emailList;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getSingleOptionCount() {
        return singleOptionCount;
    }

    public void setSingleOptionCount(Integer singleOptionCount) {
        this.singleOptionCount = singleOptionCount;
    }

    public Integer getMultiplyOptionCount() {
        return multiplyOptionCount;
    }

    public void setMultiplyOptionCount(Integer multiplyOptionCount) {
        this.multiplyOptionCount = multiplyOptionCount;
    }

    public Integer getPointPerSingleOption() {
        return pointPerSingleOption;
    }

    public void setPointPerSingleOption(Integer pointPerSingleOption) {
        this.pointPerSingleOption = pointPerSingleOption;
    }

    public Integer getPointPerMultiplyOption() {
        return pointPerMultiplyOption;
    }

    public void setPointPerMultiplyOption(Integer pointPerMultiplyOption) {
        this.pointPerMultiplyOption = pointPerMultiplyOption;
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

    public List<String> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<String> emailList) {
        this.emailList = emailList;
    }
}
