package cn.edu.nju.software.onlineexamsystem.entity;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/03
 */
public class ExamSettingEntity {

    private Integer id;
    private String subject;
    private Integer singleOptionCount;
    private Integer multiplyOptionCount;
    private Integer pointPerSingleOption;
    private Integer pointPerMultiplyOption;

    public ExamSettingEntity(String subject, Integer singleOptionCount, Integer multiplyOptionCount, Integer pointPerSingleOption, Integer pointPerMultiplyOption) {
        this.subject = subject;
        this.singleOptionCount = singleOptionCount;
        this.multiplyOptionCount = multiplyOptionCount;
        this.pointPerSingleOption = pointPerSingleOption;
        this.pointPerMultiplyOption = pointPerMultiplyOption;
    }

    public ExamSettingEntity(Integer id, String subject, Integer singleOptionCount, Integer multiplyOptionCount, Integer pointPerSingleOption, Integer pointPerMultiplyOption) {
        this.id = id;
        this.subject = subject;
        this.singleOptionCount = singleOptionCount;
        this.multiplyOptionCount = multiplyOptionCount;
        this.pointPerSingleOption = pointPerSingleOption;
        this.pointPerMultiplyOption = pointPerMultiplyOption;
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

}
