package cn.edu.nju.software.onlineexamsystem.exception;

import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘兴
 * @date 2017/10/31
 * @version 1.0
 */
@Aspect
@Component
public class HttpAspect {


    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ExceptionHandle exceptionHandle;

    @Pointcut("execution(public * cn.edu.nju.software.onlineexamsystem.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        LOGGER.info("url={}",request.getRequestURL());
        LOGGER.info("method={}",request.getMethod());
        LOGGER.info("id={}",request.getRemoteAddr());
        LOGGER.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @Around("log()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ResponseVO result = null;
        try {

        } catch (Exception e) {
            return exceptionHandle.exceptionGet(e);
        }

        if(result == null){
            return proceedingJoinPoint.proceed();
        }else {
            return result;
        }
    }

    /**
     * 打印输出结果
     * @param object
     */
    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfterReturning(Object object){
        LOGGER.info("response={}",object.toString());
    }

}
