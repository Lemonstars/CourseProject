package cn.edu.nju.software.onlineexamsystem.util;

import cn.edu.nju.software.onlineexamsystem.exception.ExceptionEnum;
import cn.edu.nju.software.onlineexamsystem.vo.ResponseVO;

/**
 * 包装返回json数据的工具类
 *
 * @author 刘兴
 * @date 2017/10/31
 * @version 1.0
 */
public class ResponseUtil {

    /**
     * 请求正确，状态码为0
     * @param object 返回的数据
     * @return
     */
    public static ResponseVO success(Object object){
        ResponseVO responseVO = new ResponseVO(0, object);
        return responseVO;
    }

    /**
     * 请求正确，无返回数据
     * @return
     */
    public static ResponseVO success(){
        return success("success");
    }

    /**
     * 请求错误
     * @param exceptionEnum
     * @return
     */
    public static ResponseVO error(ExceptionEnum exceptionEnum){
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(exceptionEnum.getCode());
        responseVO.setData(exceptionEnum.getData());
        return responseVO;
    }
}
