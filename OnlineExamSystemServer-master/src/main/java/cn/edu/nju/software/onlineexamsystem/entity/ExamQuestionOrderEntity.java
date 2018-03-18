package cn.edu.nju.software.onlineexamsystem.entity;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/09
 */
public class ExamQuestionOrderEntity {

    private Integer id;
    private String email;
    private String singleOptionOrder;
    private String multiplyOptionOrder;
    private Integer examSettingId;

    public ExamQuestionOrderEntity(String email, String singleOptionOrder, String multiplyOptionOrder, Integer examSettingId) {
        this.email = email;
        this.singleOptionOrder = singleOptionOrder;
        this.multiplyOptionOrder = multiplyOptionOrder;
        this.examSettingId = examSettingId;
    }

    public ExamQuestionOrderEntity(Integer id, String email, String singleOptionOrder, String multiplyOptionOrder, Integer examSettingId) {
        this.id = id;
        this.email = email;
        this.singleOptionOrder = singleOptionOrder;
        this.multiplyOptionOrder = multiplyOptionOrder;
        this.examSettingId = examSettingId;
    }

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

    public String getSingleOptionOrder() {
        return singleOptionOrder;
    }

    public void setSingleOptionOrder(String singleOptionOrder) {
        this.singleOptionOrder = singleOptionOrder;
    }

    public String getMultiplyOptionOrder() {
        return multiplyOptionOrder;
    }

    public void setMultiplyOptionOrder(String multiplyOptionOrder) {
        this.multiplyOptionOrder = multiplyOptionOrder;
    }

    public Integer getExamSettingId() {
        return examSettingId;
    }

    public void setExamSettingId(Integer examSettingId) {
        this.examSettingId = examSettingId;
    }
}
