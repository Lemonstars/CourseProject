package cn.edu.nju.software.onlineexamsystem.vo;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/11
 */
public class UserVO {

    private Integer id;
    private String name;
    private String studentId;
    private String email;
    private Integer gradeId;
    private Integer classId;

    public UserVO(Integer id, String name, String studentId, String email, Integer gradeId, Integer classId) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.gradeId = gradeId;
        this.classId = classId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
