package cn.edu.nju.software.onlineexamsystem.vo;

/**
 * json返回数据的包装类：包含请求状态码和数据
 *
 * @author 刘兴
 * @date 2017/10/31
 * @version 1.0
 */
public class ResponseVO<T> {

    private Integer code;
    private T data;

    public ResponseVO(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseVO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
