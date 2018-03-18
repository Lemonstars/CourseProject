package cn.edu.nju.software.onlineexamsystem.service;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/10
 */
public interface TokenService {

    /**
     * 生成token
     * @param email
     * @return
     */
    String generateToken(String email);

    /**
     * 检查token是否有效
     * @param token
     * @return
     */
    boolean checkToken(String token);
}
