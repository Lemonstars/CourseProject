package cn.edu.nju.software.onlineexamsystem.vo;

import java.util.List;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/06
 */
public class PaperVO {

    private Integer id;
    private String subject;
    private String startTime;
    private String endTime;
    private Integer pointPerSingleOption;
    private Integer pointPerMultiplyOption;
    private List<OptionQuestionVO> singleOptionList;
    private List<OptionQuestionVO> multiplyOptionList;

    public PaperVO(Integer id, String subject, String startTime, String endTime, Integer pointPerSingleOption,
                   Integer pointPerMultiplyOption, List<OptionQuestionVO> singleOptionList, List<OptionQuestionVO> multiplyOptionList) {
        this.id = id;
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pointPerSingleOption = pointPerSingleOption;
        this.pointPerMultiplyOption = pointPerMultiplyOption;
        this.singleOptionList = singleOptionList;
        this.multiplyOptionList = multiplyOptionList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public List<OptionQuestionVO> getSingleOptionList() {
        return singleOptionList;
    }

    public void setSingleOptionList(List<OptionQuestionVO> singleOptionList) {
        this.singleOptionList = singleOptionList;
    }

    public List<OptionQuestionVO> getMultiplyOptionList() {
        return multiplyOptionList;
    }

    public void setMultiplyOptionList(List<OptionQuestionVO> multiplyOptionList) {
        this.multiplyOptionList = multiplyOptionList;
    }

    @Override
    public String toString() {
        return "PaperVO{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", pointPerSingleOption=" + pointPerSingleOption +
                ", pointPerMultiplyOption=" + pointPerMultiplyOption +
                ", singleOptionList=" + singleOptionList +
                ", multiplyOptionList=" + multiplyOptionList +
                '}';
    }
}
