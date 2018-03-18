package service.implement;

import model.AssociatorEntity;
import model.BankEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AssociatorRepository;
import repository.BankRepository;
import service.ApplyNewMemberService;

@Service
public class ApplyNewMemberServiceImp implements ApplyNewMemberService{


    @Autowired
    AssociatorRepository associatorRepository;
    @Autowired
    BankRepository bankRepository;

    @Override
    public int applyNewMember(String name, String icard, String phone,
                               String bank_Num, String bank_password, String isMember,
                               String password1, String password2) {
        int aid=-1;

        if(password1.equals(password2) && !password1.equals("")){
            AssociatorEntity associatorEntity=new AssociatorEntity();
            associatorEntity.setName(name);
            associatorEntity.setIcard(icard);
            associatorEntity.setPhone(phone);
            associatorEntity.setPassword(password1);
            associatorEntity.setPoint(0);
            associatorEntity.setLevel(0);
            associatorEntity.setStatus("1");
            associatorEntity.setBankId(bank_Num);

            if(isMember.equals("yes")){
                associatorEntity.setBalace(1000);
            }else {
                associatorEntity.setBalace(0);
            }
            associatorRepository.saveAndFlush(associatorEntity);
            aid=associatorEntity.getAid();

            BankEntity bankEntity=new BankEntity();
            bankEntity.setBankId(bank_Num);
            bankEntity.setBalance(100000);
            bankRepository.saveAndFlush(bankEntity);
        }

        return aid;
    }
}
