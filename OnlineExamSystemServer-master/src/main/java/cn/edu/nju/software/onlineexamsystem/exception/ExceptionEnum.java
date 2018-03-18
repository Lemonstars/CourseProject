package cn.edu.nju.software.onlineexamsystem.exception;

/**
 * 异常枚举
 *
 * @author 刘兴
 * @date 2017/10/31
 * @version 1.0
 */
public enum  ExceptionEnum {
    ERROR(-1, "错误"),
    REGISTER_ERROR(1000, "账号已被注册"),
    ACCOUNT_ERROR(1001, "账号错误"),
    REGISTER_CODE_ERROR(1003, "注册验证码错误"),
    FILE_UPLOAD_FAIL(2000, "文件上传失败"),
    FILE_SUBJECT_EXIST_FAIL(2001, "科目已存在"),
    EXAM_PASSWORD_ERROR(3000, "考试密码错误"),
    EXAM_TOO_EARLY(3001, "考试尚未开始"),
    EXAM_TOO_LATE(3002, "考试已经结束"),
    EXAM_SUBJECT_NOT_EXIST(4000, "该科目不存在")
    ;

    private Integer code;
    private String data;

    ExceptionEnum(Integer code, String data) {
        this.code = code;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
