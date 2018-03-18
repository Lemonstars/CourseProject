package service.implement;

import model.ApplyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ApplyRepository;
import service.ApplyNewBranchService;
import util.MyDate;

import java.sql.Date;

/**
 * Created by starrylemon on 2017/3/13.
 */


@Service
public class ApplyNewBranchServiceImp implements ApplyNewBranchService {

    @Autowired
    ApplyRepository applyRepository;

    @Transactional
    @Override
    public int applyNewBranch(String applyName, String icard, String bank_number, String city, String address, String numOfRoom, String password1, String password2) {
        int result=-1;

        if(strIsNotNull(applyName) && strIsNotNull(icard)&&
                strIsNotNull(bank_number) && strIsNotNull(city) &&
                strIsNotNull(address) && strIsNotNull(numOfRoom) &&
                strIsNotNull(password1) && strIsNotNull(password2)){
            if(vertifyPassword(password1,password2)){

                MyDate myDate=MyDate.getInstance();

                ApplyEntity applyEntity=new ApplyEntity();
                applyEntity.setApplyerName(applyName);
                applyEntity.setIcard(icard);
                applyEntity.setBankNumber(bank_number);
                applyEntity.setAddress(city);
                applyEntity.setName(address);
                applyEntity.setNumOfRoom(Integer.parseInt(numOfRoom));
                String todayDate=myDate.getTodayDate();
                Date date_sql=Date.valueOf(todayDate);
                applyEntity.setApplyTime(date_sql);
                applyEntity.setStatus("0");
                applyEntity.setPassword(password1);

                applyRepository.saveAndFlush(applyEntity);
                result=applyEntity.getId();
            }
        }

        return result;
    }

    private boolean vertifyPassword(String pass1,String pass2){
        if(pass1.equals(pass2) && !pass1.equals("")){
            return true;
        }
        return false;
    }


    private boolean strIsNotNull(String str){
        if(str!=null && !str.equals("")){
            return true;
        }
        return false;
    }
}
