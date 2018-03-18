package cn.edu.nju.software.onlineexamsystem.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/02
 */
public class SubjectVO {

    private String subject;
    private int singleOptionCount;
    private int multiplyOptionCount;

    public SubjectVO(String subject, int singleOptionCount, int multiplyOptionCount) {
        this.subject = subject;
        this.singleOptionCount = singleOptionCount;
        this.multiplyOptionCount = multiplyOptionCount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSingleOptionCount() {
        return singleOptionCount;
    }

    public void setSingleOptionCount(int singleOptionCount) {
        this.singleOptionCount = singleOptionCount;
    }

    public int getMultiplyOptionCount() {
        return multiplyOptionCount;
    }

    public void setMultiplyOptionCount(int multiplyOptionCount) {
        this.multiplyOptionCount = multiplyOptionCount;
    }
}
