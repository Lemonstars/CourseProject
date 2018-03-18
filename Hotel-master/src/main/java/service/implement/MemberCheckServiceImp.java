package service.implement;


import model.AssociatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AssociatorRepository;
import service.MemberCheckService;

import java.util.List;

@Service
public class MemberCheckServiceImp implements MemberCheckService{

    @Autowired
    AssociatorRepository associatorRepository;

    @Override
    public void checkAllMember() {
        List<AssociatorEntity> allAss=associatorRepository.findAll();
        for(AssociatorEntity associatorEntity:allAss){
            double balance=associatorEntity.getBalace();
            int aid=associatorEntity.getAid();
            if(balance<0){
                associatorRepository.setStatus("2",aid);
            }else if(balance<100){
                associatorRepository.setStatus("1",aid);
            }else if(balance>1000){
                associatorRepository.setStatus("0",aid);
            }

        }
    }
}
