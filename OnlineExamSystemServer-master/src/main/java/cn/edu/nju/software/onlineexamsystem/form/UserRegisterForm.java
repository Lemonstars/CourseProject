package cn.edu.nju.software.onlineexamsystem.form;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/05
 */
public class UserRegisterForm {

    private String name;
    private String studentId;
    private String email;
    private Integer gradeId;
    private Integer classId;
    private String password;
    private String registerCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", gradeId=" + gradeId +
                ", classId=" + classId +
                ", password='" + password + '\'' +
                '}';
    }
}
