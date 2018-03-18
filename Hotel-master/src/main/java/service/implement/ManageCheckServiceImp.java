package service.implement;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.*;
import service.ManagerCheckService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by starrylemon on 2017/3/15.
 */

@Service
public class ManageCheckServiceImp implements ManagerCheckService {

    @Autowired
    ApplyRepository applyRepository;
    @Autowired
    ChangeInfroRepository changeInfroRepository;

    @Autowired
    BranchRepository branchRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    BankRepository bankRepository;

    @Override
    public List<ApplyEntity> getApplyList() {
        List<ApplyEntity> result = applyRepository.findAll();

        return result;
    }

    @Override
    public List<ChangeInforEntity> getChangeInforList() {
        List<ChangeInforEntity> result = changeInfroRepository.findAll();
        return result;
    }

    @Override
    public void deleteApplyBranch(String id) {
        applyRepository.delete(Integer.parseInt(id));
    }

    @Transactional
    @Override
    public void refuseApplyBranch(String id) {
         applyRepository.modifyStatuById("2",Integer.parseInt(id));
         applyRepository.flush();
    }

    @Transactional
    @Override
    public void acceptApplyBranch(String id) {

        applyRepository.modifyStatuById("1",Integer.parseInt(id));
        applyRepository.flush();

        ApplyEntity applyEntity=applyRepository.findOne(Integer.parseInt(id));
        String icard=applyEntity.getIcard();
        String bank_number=applyEntity.getBankNumber();
        String city=applyEntity.getAddress();
        String address=applyEntity.getName();
        int roomNum=applyEntity.getNumOfRoom();
        String applyName=applyEntity.getApplyerName();
        String password=applyEntity.getPassword();
        String bank_num=applyEntity.getBankNumber();

        BankEntity bankEntity=new BankEntity();
        bankEntity.setBankId(bank_num);
        bankEntity.setBalance(100000);
        bankRepository.saveAndFlush(bankEntity);

        BranchEntity branchEntity=new BranchEntity();
        branchEntity.setIcard(icard);
        branchEntity.setBankNumber(bank_number);
        branchEntity.setAddress(city);
        branchEntity.setName(address);
        branchEntity.setFreeNumber(roomNum);
        branchEntity.setReserveNumber(0);
        branchEntity.setUseNumber(0);
        branchRepository.saveAndFlush(branchEntity);

        RoomEntity room1=new RoomEntity();
        room1.setBranchByHid(branchEntity);
        room1.setType("1");
        room1.setPrice(599);
        RoomEntity room2=new RoomEntity();
        room2.setBranchByHid(branchEntity);
        room2.setType("2");
        room2.setPrice(399);
        RoomEntity room3=new RoomEntity();
        room3.setBranchByHid(branchEntity);
        room3.setType("3");
        room3.setPrice(199);

        List<RoomEntity> roomEntities=new ArrayList<>();
        roomEntities.add(room1);
        roomEntities.add(room2);
        roomEntities.add(room3);
        roomRepository.save(roomEntities);
        roomRepository.flush();

        EmployeeEntity employeeEntity=new EmployeeEntity();
        employeeEntity.setId(Integer.parseInt(id));
        employeeEntity.setBranchByHid(branchEntity);
        employeeEntity.setName(applyName);
        employeeEntity.setSex("男");
        employeeEntity.setIcard(icard);
        employeeEntity.setPassword(password);
        employeeRepository.saveAndFlush(employeeEntity);
    }

    @Transactional
    @Override
    public void delelteChangeInfor(String id) {
        changeInfroRepository.delete(Integer.parseInt(id));
    }

    @Transactional
    @Override
    public void refuseChangeInfor(String id) {
        changeInfroRepository.modifyStatuById("2",Integer.parseInt(id));
    }

    @Transactional
    @Override
    public void acceptChangeInfor(String id) {
        changeInfroRepository.modifyStatuById("1",Integer.parseInt(id));

        ChangeInforEntity changeInforEntity=changeInfroRepository.findOne(Integer.parseInt(id));
        int branchID=changeInforEntity.getBranchId();
        String newIcard=changeInforEntity.getNewIcard();
        String newCity=changeInforEntity.getNewCity();
        String newAddress=changeInforEntity.getNewAddress();
        int  newNumOfRoom=changeInforEntity.getNewNumOfRoom();
        branchRepository.modifyContentById(newIcard,newCity,newAddress,newNumOfRoom,0,0,branchID);
    }


}
