package service.implement;

import model.BranchEntity;
import model.EmployeeEntity;
import model.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.EmployeeRepository;
import repository.RoomRepository;
import service.BranchPlanService;

import java.util.ArrayList;
import java.util.List;



@Service
public class BranchPlanServiceImp implements BranchPlanService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Integer> getRoomPrice(String eid) {
        List<Integer> result=new ArrayList<>(3);
        EmployeeEntity employeeEntity=employeeRepository.findOne(Integer.parseInt(eid));
        BranchEntity branchEntity=employeeEntity.getBranchByHid();
        RoomEntity roomEntity_1=roomRepository.getRoom(branchEntity,"1");
        int firstPrice=roomEntity_1.getPrice();
        RoomEntity roomEntity_2=roomRepository.getRoom(branchEntity,"2");
        int secondPrice=roomEntity_2.getPrice();
        RoomEntity roomEntity_3=roomRepository.getRoom(branchEntity,"3");
        int thirdPrice=roomEntity_3.getPrice();
        result.add(firstPrice);
        result.add(secondPrice);
        result.add(thirdPrice);

        return result;
    }

    @Transactional
    @Override
    public void setRoom1Price(String eid,String price) {
         this.setPrice(eid,price,"1");
    }

    @Transactional
    @Override
    public void setRoom2Price(String eid,String price) {
        this.setPrice(eid,price,"2");
    }

    @Transactional
    @Override
    public void setRoom3Price(String eid,String price) {
        this.setPrice(eid,price,"3");
    }

    private void setPrice(String eid,String price,String type){
        EmployeeEntity employeeEntity=employeeRepository.findOne(Integer.parseInt(eid));
        BranchEntity branchEntity=employeeEntity.getBranchByHid();
        RoomEntity roomEntity=roomRepository.getRoom(branchEntity,type);
        int roomPrice=roomEntity.getPrice();

        try {
            roomPrice = Integer.parseInt(price);
        }catch (Exception e){
            e.printStackTrace();
        }
        roomRepository.setPriceByHid(roomPrice,branchEntity,type);
    }


}
