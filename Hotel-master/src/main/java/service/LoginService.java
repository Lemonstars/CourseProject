package service;

/**
 * Created by starrylemon on 2017/3/6.
 */
public interface LoginService {

    boolean judgeAssociator(String id,String password);

    boolean judgeEmployee(String id,String password);

    boolean judgeManager(String id,String password);
}
