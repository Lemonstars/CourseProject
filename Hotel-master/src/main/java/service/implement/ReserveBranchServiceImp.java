package service.implement;

import model.AssociatorEntity;
import model.BranchEntity;
import model.CenterPayEntity;
import model.ReserveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.*;
import service.ReserveBranchService;
import util.MyDate;

import java.sql.Date;


/**
 * Created by starrylemon on 2017/3/11.
 */

@Service
public class ReserveBranchServiceImp implements ReserveBranchService {

    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    BranchRepository branchRepository;
    @Autowired
    AssociatorRepository associatorRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    Center_payRepository center_payRepository;

    @Transactional
    public void reserveBranch(String id, String branchId, String date, String payType, String roomType) {
        MyDate date_single=MyDate.getInstance();

        AssociatorEntity associatorEntity=associatorRepository.findOne(Integer.parseInt(id));
        String bankId=associatorEntity.getBankId();

        BranchEntity branchEntity=branchRepository.findOne(Integer.parseInt(branchId));
        String branch_bankNum=branchEntity.getBankNumber();
        String target_time=date_single.convertDate(date);
        String operate_time= date_single.getTodayDate();
        Date target_time_sql=Date.valueOf(target_time);
        Date operate_time_sql=Date.valueOf(operate_time);

        ReserveEntity reserveEntity=new ReserveEntity();
        reserveEntity.setAssociatorByAid(associatorEntity);
        reserveEntity.setBranchByHid(branchEntity);
        reserveEntity.setTargetTime(target_time_sql);
        reserveEntity.setOperatTime(operate_time_sql);
        reserveEntity.setStatus("0");
        reserveEntity.setRoomType(roomType);

        double balanceBefore=associatorEntity.getBalace();
        double roomPrice=roomRepository.getRoom(branchEntity,roomType).getPrice();
        double balanceNow=balanceBefore-roomPrice;

        reserveRepository.save(reserveEntity);
        if(payType.equals("option1")){
            //会员卡
            associatorRepository.setBalance(balanceNow,Integer.parseInt(id));
            CenterPayEntity centerPayEntity=new CenterPayEntity();
            centerPayEntity.setType("0");
            centerPayEntity.setDate(operate_time_sql);
            centerPayEntity.setAid(Integer.parseInt(id));
            centerPayEntity.setPrice(roomPrice);
            centerPayEntity.setStatus("0");
            center_payRepository.saveAndFlush(centerPayEntity);

        } else if(payType.equals("option2")){
            //银行卡
             double beforeBalance=bankRepository.getBalanceById( bankId);
             double nowBalance=beforeBalance - roomPrice;
             bankRepository.setBankBalanc(nowBalance,bankId);

             double branchBeforeBalance=bankRepository.getBalanceById(branch_bankNum);
             double branchNowBalace=branchBeforeBalance+roomPrice;
             bankRepository.setBankBalanc(branchNowBalace,branch_bankNum);
        }

    }


}
