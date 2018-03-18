package service.implement;

import model.BranchEntity;
import model.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BranchRepository;
import repository.RoomRepository;
import service.BranchInforService;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by starrylemon on 2017/3/9.
 */

@Service
public class BranchInforServiceImp implements BranchInforService {

    @Autowired
    BranchRepository branchRepository;
    @Autowired
    RoomRepository roomRepository;

    @Override
    public Map<String, List> getBranchAddressInfor() {

        List<String> cities=new ArrayList<>();
        List<BranchEntity> branchEntities;
        Map<String,List> result=new Hashtable<>();

        branchEntities=branchRepository.findAll();
        for(BranchEntity branchEntity:branchEntities){
            String city=branchEntity.getAddress();
            boolean isSame=false;
            for(int i=0;i<cities.size();i++){
                if(city.equals(cities.get(i))){
                    isSame=true;
                    break;
                }
            }
            if(!isSame){
                cities.add(city);
            }
        }


        for(int i=0;i<cities.size();i++){
            String cityName=cities.get(i);
            ArrayList<BranchEntity> address =new ArrayList<>();
            for(BranchEntity branchEntity:branchEntities){
                if (branchEntity.getAddress().equals( cityName)){
                    address.add(branchEntity);
                }
            }
            result.put(cityName,address);
        }

        return  result;
    }

    @Override
    public List<RoomEntity> getBranchPriceInfor() {
        List<RoomEntity> result=roomRepository.findAll();
        return result;
    }
}
