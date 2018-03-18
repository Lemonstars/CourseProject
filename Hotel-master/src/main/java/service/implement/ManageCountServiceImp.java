package service.implement;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.*;
import service.ManageCountService;
import vo.BranchCheckInVO;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starrylemon on 2017/3/16.
 */

@Service
public class ManageCountServiceImp implements ManageCountService {

    @Autowired
    BranchRepository branchRepository;
    @Autowired
    Center_payRepository centerPayRepository;
    @Autowired
    AssociatorRepository associatorRepository;
    @Autowired
    BankRepository bankRepository;
    @Autowired
    ConsumeRepository consumeRepository;
    @Autowired
    ReserveRepository reserveRepository;

    @Override
    public List<BranchCheckInVO> getBranchCheckInList() {
        List<BranchCheckInVO> result=new ArrayList<>();

        BranchCheckInVO branchCheckInVO;

        List<BranchEntity> branchEntities=branchRepository.findAll();
        for(BranchEntity branchEntity:branchEntities){
            branchCheckInVO=new BranchCheckInVO();
            branchCheckInVO.setId( branchEntity.getId());
            branchCheckInVO.setCity(branchEntity.getAddress());
            branchCheckInVO.setAddress(branchEntity.getName());
            int numOfRoom=branchEntity.getFreeNumber();
            int numOfUse =branchEntity.getUseNumber();
            branchCheckInVO.setNumOfRoom(numOfRoom);
            branchCheckInVO.setNumOfUse(numOfUse);
            branchCheckInVO.setNumOfReserve(branchEntity.getReserveNumber());
            double rate=100.0*numOfUse/numOfRoom;
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setMaximumFractionDigits(2);
            branchCheckInVO.setRateOfUse(numberFormat.format(rate)+"%");
            result.add(branchCheckInVO);
        }

        return result;
    }

    @Override
    public List<CenterPayEntity> getCenterPayConsumeList() {
        List<CenterPayEntity> result=centerPayRepository.findByType("1");
        return result;
    }

    @Override
    public List<CenterPayEntity> getCenterPayReserveList() {
        List<CenterPayEntity> result=centerPayRepository.findByType("0");
        return result;
    }

    @Transactional
    @Override
    public void finalizeCenterPay(String id) {
        centerPayRepository.changeStatus("1",Integer.parseInt(id));
        CenterPayEntity centerPayEntity=centerPayRepository.findOne(Integer.parseInt(id));
        int hid=centerPayEntity.getHid();
        double addMoney=centerPayEntity.getPrice();
        BranchEntity branchEntity=branchRepository.findOne(hid);
        String bankNum=branchEntity.getBankNumber();
        double beforeMoney=bankRepository.getBalanceById(bankNum);
        double nowMoney=beforeMoney+addMoney;
        bankRepository.setBankBalanc(nowMoney,bankNum);
    }

    @Override
    public void deleteCenterPay(String id) {
        centerPayRepository.delete(Integer.parseInt(id));
    }

    @Transactional
    @Override
    public void finalizeAllCenterPay_Consume() {
        List<CenterPayEntity> consumList=this.getCenterPayConsumeList();
        for(CenterPayEntity centerPayEntity:consumList){
            String id=centerPayEntity.getId()+"";
            this.finalizeCenterPay(id);
        }
    }

    @Transactional
    @Override
    public void finalizeAllCenterPay_Reserve() {
        List<CenterPayEntity> reserveList=this.getCenterPayReserveList();
        for(CenterPayEntity centerPayEntity:reserveList){
            String id=centerPayEntity.getId()+"";
            this.finalizeCenterPay(id);
        }
    }

    @Transactional
    @Override
    public void deleteAllCenterPay_Consume() {
        List<CenterPayEntity> consumList=this.getCenterPayConsumeList();
        for(CenterPayEntity centerPayEntity:consumList){
            String id=centerPayEntity.getId()+"";
            this.deleteCenterPay(id);
        }
    }

    @Transactional
    @Override
    public void deleteAllCenterPay_Reserve() {
        List<CenterPayEntity> reserveList=this.getCenterPayReserveList();
        for(CenterPayEntity centerPayEntity:reserveList){
            String id=centerPayEntity.getId()+"";
            this.deleteCenterPay(id);
        }
    }

    @Override
    public List<ConsumeEntity> getAllConsume() {

        List<ConsumeEntity> result=consumeRepository.findOrderByHid();

        return result;
    }

    @Override
    public List<ReserveEntity> getAllReserve() {

        List<ReserveEntity> result=reserveRepository.findOrderByHid();
        return result;
    }

    @Override
    public String getConsumeNumPerMonth() {
        String result;

        double[] money=new double[15];
        for(int i=0;i<money.length;i++){
            money[i]=0;
        }

        List<ConsumeEntity> allConsumeEntiies=this.getAllConsume();
        for(ConsumeEntity consumeEntity:allConsumeEntiies){
            String date=consumeEntity.getTime().toString();
            int index=getMonthIndex(date);
            money[index]+=consumeEntity.getPrice();
        }

        result="[";
        for(int i=0;i<money.length;i++){
            if(i!=money.length-1){
                result+= ( money[i]+"," );
            }else {
                result+=money[i];
            }
        }
        result+="]";

        return result;
    }

    private int getMonthIndex(String date){
        int result;

        String[] split=date.split("-");
        int year=Integer.parseInt(split[0]);
        int month=Integer.parseInt(split[1]);
        result=(year-2016)*12+(month-1);

        return result;
    }
}
