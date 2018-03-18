package service.implement;

import model.CheckInEntity;
import model.ConsumeEntity;
import model.EmployeeEntity;
import model.ReserveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CheckInRepository;
import repository.ConsumeRepository;
import repository.EmployeeRepository;
import repository.ReserveRepository;
import service.BranchCountService;

import java.util.ArrayList;
import java.util.List;


@Service
public class BranchCountServiceImp implements BranchCountService {

    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    CheckInRepository checkInRepository;
    @Autowired
    ConsumeRepository consumeRepository;
    @Autowired
    EmployeeRepository employeeRepository;

//    @Override
//    public List<ReserveEntity> getReserveList() {
//        List<ReserveEntity> result=reserveRepository.findAll();
//        return result;
//    }
//
//    @Override
//    public List<CheckInEntity> getCheckInList() {
//        List<CheckInEntity> result=checkInRepository.findAll();
//        return result;
//    }
//
//    @Override
//    public List<ConsumeEntity> getConsumeList() {
//        List<ConsumeEntity> result=consumeRepository.findAll();
//        return result;
//    }

    @Override
    public int[] getReserveRoomNum(int hid) {
        int[] result=new int[3];
        for(int i=0;i<result.length;i++){
            result[i]=0;
        }

        List<ReserveEntity> reserveList=this.getReserveList(hid);
        for(ReserveEntity reserve:reserveList){
            String type=reserve.getRoomType();
            int index=Integer.parseInt(type)-1;
            result[index]++;
        }

        return result;
    }

    @Override
    public int[] getCheckInRoomNum(int hid) {
        int[] result=new int[3];
        for(int i=0;i<result.length;i++){
            result[i]=0;
        }
        List<CheckInEntity> checkInList=this.getCheckInList(hid);
        for(CheckInEntity checkInEntity:checkInList){
            String type=checkInEntity.getRoomType();
            int index=Integer.parseInt(type)-1;
            result[index]++;
        }

        return result;
    }

    @Override
    public double[] getConsumePriceNum(int hid) {
        double[] result=new double[3];
        for(int i=0;i<result.length;i++){
            result[i]=0;
        }
        List<ConsumeEntity> consumeList=this.getConsumeList(hid);
        for(ConsumeEntity consume:consumeList){
            String type=consume.getRoomType();
            int index=Integer.parseInt(type)-1;
            result[index]+=consume.getPrice();
        }

        return result;
    }

    @Override
    public List<ReserveEntity> getReserveList(int id) {
        List<ReserveEntity> all=reserveRepository.findAll();
        List<ReserveEntity> result=new ArrayList<>();
        for(ReserveEntity reserveEntity:all){
            int target=reserveEntity.getBranchByHid().getId();
            if(target == id){
                result.add(reserveEntity);
            }
        }

        return result;
    }

    @Override
    public List<CheckInEntity> getCheckInList(int id) {
        List<CheckInEntity> all=checkInRepository.findAll();
        List<CheckInEntity> result=new ArrayList<>();
        for(CheckInEntity checkInEntity:all){
            int target=checkInEntity.getId();
            if(target == id){
                result.add(checkInEntity);
            }
        }

        return result;
    }

    @Override
    public List<ConsumeEntity> getConsumeList(int id) {
        List<ConsumeEntity> all=consumeRepository.findAll();
        List<ConsumeEntity> result=new ArrayList<>();
        for(ConsumeEntity consumeEntity:all){
            int target=consumeEntity.getId();
            if(target == id){
                result.add(consumeEntity);
            }
        }

        return result;
    }

    @Override
    public int getHidByEid(String eid) {
        EmployeeEntity employeeEntity=employeeRepository.findOne(Integer.parseInt(eid));
        int hid=employeeEntity.getBranchByHid().getId();

        return hid;
    }
}
