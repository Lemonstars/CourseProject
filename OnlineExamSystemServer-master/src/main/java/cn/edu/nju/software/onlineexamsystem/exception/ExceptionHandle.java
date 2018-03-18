package cn.edu.nju.software.onlineexamsystem.exception;


import cn.edu.nju.software.onlineexamsystem.util.ResponseUtil;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理的aop通知，返回的json数据包含相应的状态码和描述
 *
 * @author 刘兴
 * @date 2017/10/31
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVO exceptionGet(Exception e){
        return ResponseUtil.error(ExceptionEnum.ERROR);
    }

}
