package cn.edu.nju.software.onlineexamsystem.service.impl;

import cn.edu.nju.software.onlineexamsystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/10
 */
@Service
public class TokenServiceImpl implements TokenService{

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public String generateToken(String email) {
        String uuid = UUID.randomUUID().toString();
        String uuidWithoutLine = uuid.replace('-','.');
        String token = uuidWithoutLine+"-"+email;

        stringRedisTemplate.opsForValue().set(email, token);
        stringRedisTemplate.expire(email, 1, TimeUnit.HOURS);

        return token;
    }

    @Override
    public boolean checkToken(String token) {
        String[] tokenSplit = token.split("-");
        String uuid = tokenSplit[0];
        String email = tokenSplit[1];

        if(StringUtils.isEmpty(email) || StringUtils.isEmpty(uuid)){
            return false;
        }

        String redisToken = stringRedisTemplate.opsForValue().get(email);
        if(!token.equals(redisToken)){
            return false;
        }

        stringRedisTemplate.expire(email, 1, TimeUnit.HOURS);
        return true;
    }
}
