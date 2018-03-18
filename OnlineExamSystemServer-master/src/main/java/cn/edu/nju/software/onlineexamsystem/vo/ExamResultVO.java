package cn.edu.nju.software.onlineexamsystem.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */
public class ExamResultVO {

    public static final int COMMON = 0;
    public static final int ABSENT = 1;

    private String studentId;
    private String studentName;
    private String studentEmail;
    private Integer point;
    private Integer status;

    public ExamResultVO(String studentId, String studentName, String studentEmail, Integer point, Integer status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.point = point;
        this.status = status;
    }

    public ExamResultVO() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExamResultVO{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", point=" + point +
                ", status=" + status +
                '}';
    }
}
