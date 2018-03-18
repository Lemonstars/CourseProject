package service.implement;

import model.AssociatorEntity;
import model.BankEntity;
import model.CenterPayEntity;
import model.ConsumeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AssociatorRepository;
import repository.BankRepository;
import repository.Center_payRepository;
import repository.ConsumeRepository;
import service.BranchRegisterOutService;
import util.MyDate;

import java.sql.Date;


@Service
public class BranchRegisterOutServiceImp implements BranchRegisterOutService {

    @Autowired
    ConsumeRepository consumeRepository;
    @Autowired
    AssociatorRepository associatorRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    Center_payRepository centerPayRepository;

    @Transactional
    @Override
    public void registerOut(String aid, String hid, String pay_type, String room_type, String price) {
        String toddy= MyDate.getInstance().getTodayDate();
        Date today_sql= java.sql.Date.valueOf(toddy);

        ConsumeEntity consumeEntity=new ConsumeEntity();
        consumeEntity.setAid(Integer.parseInt(aid));
        consumeEntity.setHid(Integer.parseInt(hid));
        consumeEntity.setTime(today_sql);
        consumeEntity.setPayType(pay_type);
        consumeEntity.setRoomType(room_type);
        consumeEntity.setPrice(Double.parseDouble(price));

        AssociatorEntity associatorEntity=associatorRepository.findOne(Integer.parseInt(aid));

        if(pay_type.equals("0")){
            double beforeBalance=associatorEntity.getBalace();
            double balace= beforeBalance-Double.parseDouble(price);
            associatorRepository.setBalance(balace,Integer.parseInt(aid));

            CenterPayEntity centerPayEntity=new CenterPayEntity();
            centerPayEntity.setType("1");
            centerPayEntity.setDate(today_sql);
            centerPayEntity.setAid(Integer.parseInt(aid));
            centerPayEntity.setPrice(Double.parseDouble(price));
            centerPayEntity.setStatus("0");
            centerPayEntity.setHid(Integer.parseInt(hid));
            centerPayRepository.saveAndFlush(centerPayEntity);

        }else if(pay_type.equals("1")){
            String bankId=associatorEntity.getBankId();
            double beforeBalance=bankRepository.getBalanceById(bankId);
            double nowBalance=beforeBalance-Double.parseDouble(price);
            bankRepository.setBankBalanc(nowBalance,bankId);
        }

        int sumPoint=(int)(Double.parseDouble(price)/100)+associatorEntity.getPoint();

        int level=sumPoint/100;

        associatorRepository.setLevel(level,Integer.parseInt(aid));
        associatorRepository.setPoint(sumPoint,Integer.parseInt(aid));
        consumeRepository.saveAndFlush(consumeEntity);
    }
}
