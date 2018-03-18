package service;

import model.AssociatorEntity;


/**
 * Created by starrylemon on 2017/3/12.
 */
public interface AssociatorInforService {

    AssociatorEntity getAssociatorInfor(int userId);

    void modifyAssociatorInfor(String id,String username,String icard,String phone,
                               String password1,String password2,String isMember);
}
