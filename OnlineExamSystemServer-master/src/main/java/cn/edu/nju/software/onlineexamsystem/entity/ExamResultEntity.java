package cn.edu.nju.software.onlineexamsystem.entity;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/12/10
 */
public class ExamResultEntity {

    private Integer id;
    private String studentId;
    private String studentName;
    private String subject;
    private String singleOptionQuestion;
    private String singleOptionStudentAnswer;
    private String singleOptionCorrectAnswer;
    private String multiplyOptionQuestion;
    private String multiplyOptionStudentAnswer;
    private String multiplyOptionCorrectAnswer;
    private Integer pointPerSingleOptionQuestion;
    private Integer pointPerMultiplyOptionQuestion;
    private Integer sumPoint;
    private Integer studentPoint;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSingleOptionQuestion() {
        return singleOptionQuestion;
    }

    public void setSingleOptionQuestion(String singleOptionQuestion) {
        this.singleOptionQuestion = singleOptionQuestion;
    }

    public String getSingleOptionStudentAnswer() {
        return singleOptionStudentAnswer;
    }

    public void setSingleOptionStudentAnswer(String singleOptionStudentAnswer) {
        this.singleOptionStudentAnswer = singleOptionStudentAnswer;
    }

    public String getSingleOptionCorrectAnswer() {
        return singleOptionCorrectAnswer;
    }

    public void setSingleOptionCorrectAnswer(String singleOptionCorrectAnswer) {
        this.singleOptionCorrectAnswer = singleOptionCorrectAnswer;
    }

    public String getMultiplyOptionQuestion() {
        return multiplyOptionQuestion;
    }

    public void setMultiplyOptionQuestion(String multiplyOptionQuestion) {
        this.multiplyOptionQuestion = multiplyOptionQuestion;
    }

    public String getMultiplyOptionStudentAnswer() {
        return multiplyOptionStudentAnswer;
    }

    public void setMultiplyOptionStudentAnswer(String multiplyOptionStudentAnswer) {
        this.multiplyOptionStudentAnswer = multiplyOptionStudentAnswer;
    }

    public String getMultiplyOptionCorrectAnswer() {
        return multiplyOptionCorrectAnswer;
    }

    public void setMultiplyOptionCorrectAnswer(String multiplyOptionCorrectAnswer) {
        this.multiplyOptionCorrectAnswer = multiplyOptionCorrectAnswer;
    }

    public Integer getPointPerSingleOptionQuestion() {
        return pointPerSingleOptionQuestion;
    }

    public void setPointPerSingleOptionQuestion(Integer pointPerSingleOptionQuestion) {
        this.pointPerSingleOptionQuestion = pointPerSingleOptionQuestion;
    }

    public Integer getPointPerMultiplyOptionQuestion() {
        return pointPerMultiplyOptionQuestion;
    }

    public void setPointPerMultiplyOptionQuestion(Integer pointPerMultiplyOptionQuestion) {
        this.pointPerMultiplyOptionQuestion = pointPerMultiplyOptionQuestion;
    }

    public Integer getSumPoint() {
        return sumPoint;
    }

    public void setSumPoint(Integer sumPoint) {
        this.sumPoint = sumPoint;
    }

    public Integer getStudentPoint() {
        return studentPoint;
    }

    public void setStudentPoint(Integer studentPoint) {
        this.studentPoint = studentPoint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
