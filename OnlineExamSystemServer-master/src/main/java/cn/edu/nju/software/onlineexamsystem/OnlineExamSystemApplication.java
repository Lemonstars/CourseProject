package cn.edu.nju.software.onlineexamsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 后端程序的入口
 *
 * @author 刘兴
 * @date 2017/10/29
 */
@SpringBootApplication
@MapperScan("cn.edu.nju.software.onlineexamsystem.mapper")
public class OnlineExamSystemApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OnlineExamSystemApplication.class, args);
	}

}
