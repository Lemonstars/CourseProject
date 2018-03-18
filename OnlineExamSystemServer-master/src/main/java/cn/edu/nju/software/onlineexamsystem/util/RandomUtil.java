package cn.edu.nju.software.onlineexamsystem.util;

import java.util.Random;

/**
 * @author 刘兴
 * @version 1.0
 * @date 2017/11/13
 */
public class RandomUtil {

    private static Random random = new Random();

    public static String random(){
        int ran = random.nextInt(1000000);
        String res = String.valueOf(ran);
        int digit = 6;
        if( res.length() < digit){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i < digit - res.length(); i++ ){
                sb.append('0');
            }
            res = sb + res;
        }else {
            res = res.substring(0, digit);
        }
        return res;
    }

}
