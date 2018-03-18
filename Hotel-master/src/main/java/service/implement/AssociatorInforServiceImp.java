package service.implement;

import model.AssociatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AssociatorRepository;
import service.AssociatorInforService;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Service
public class AssociatorInforServiceImp implements AssociatorInforService{

    @Autowired
    AssociatorRepository associatorRepository;

    @Override
    public AssociatorEntity getAssociatorInfor(int userId) {
        AssociatorEntity associatorEntity=associatorRepository.findOne(userId);
        return associatorEntity;
    }

    @Transactional
    @Override
    public void modifyAssociatorInfor(String id, String username, String icard, String phone,
                                      String password1, String password2,String isMember) {

        if(password1.equals(password2) && !password1.equals("")){
            String status;
            if(isMember.equals("yes")){
                status="1";
            }else {
                status="0";
            }

            associatorRepository.updateUser(username,icard,phone, password1,status,Integer.parseInt(id));
            associatorRepository.flush();
        }

    }
}
