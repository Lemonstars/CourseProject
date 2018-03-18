package service.implement;

import model.BranchEntity;
import model.ChangeInforEntity;
import model.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.BranchRepository;
import repository.ChangeInfroRepository;
import repository.EmployeeRepository;
import service.BranchChangeInforService;
import util.MyDate;
import vo.BranchChangeInforVO;

import java.sql.Date;


@Service
public class BranchChangeInforServiceImp implements BranchChangeInforService {

    @Autowired
    BranchRepository branchRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ChangeInfroRepository changeInfroRepository;

    @Override
    public BranchChangeInforVO getBranchInforByEid(String eid) {
        EmployeeEntity employeeEntity=employeeRepository.findOne(Integer.parseInt(eid));
        BranchEntity branchEntity=employeeEntity.getBranchByHid();
        int branchID=branchEntity.getId();
        String city=branchEntity.getAddress();
        String address=branchEntity.getName();
        String icard=branchEntity.getIcard();
        int numOfRoom=branchEntity.getFreeNumber()+branchEntity.getReserveNumber()+branchEntity.getUseNumber();

        BranchChangeInforVO branchChangeInforVO=new BranchChangeInforVO(branchID,city,address,
                icard,numOfRoom);

        return branchChangeInforVO;
    }

    @Transactional
    @Override
    public void applyChangeBranchInfor(String eid, String icard, String city, String address, String numOfRoom, String old_icard, String old_city, String old_address, String old_numOfRoom) {
        EmployeeEntity employeeEntity=employeeRepository.findOne(Integer.parseInt(eid));
        BranchEntity branchEntity=employeeEntity.getBranchByHid();
        int branchID=branchEntity.getId();

        String todayDate= MyDate.getInstance().getTodayDate();
        Date today_sql=Date.valueOf(todayDate);

        ChangeInforEntity changeInforEntity=new ChangeInforEntity();
        changeInforEntity.setBranchId(branchID);
        changeInforEntity.setOldIcard(old_icard);
        changeInforEntity.setOldCity(old_city);
        changeInforEntity.setOldAddress(old_address);
        changeInforEntity.setOldNumOfRoom(Integer.parseInt(old_numOfRoom));
        changeInforEntity.setNewIcard(icard);
        changeInforEntity.setNewCity(city);
        changeInforEntity.setNewAddress(address);
        changeInforEntity.setNewNumOfRoom(Integer.parseInt(numOfRoom));
        changeInforEntity.setDate(today_sql);
        changeInforEntity.setStatus("0");

        changeInfroRepository.saveAndFlush(changeInforEntity);
    }
}
