package service.implement;

import model.CheckInEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CheckInRepository;
import service.CheckInInforService;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */

@Service
public class CheckInInforServiceImp implements CheckInInforService {

    @Autowired
    CheckInRepository checkInRepository;

    @Override
    public List<CheckInEntity> getCheckInInforByUserId(String id) {

        List<CheckInEntity>result=checkInRepository.findByAid(Integer.parseInt(id));

        return result;
    }

    @Override
    public String getMaxDateByUserId(String id) {

        String date=checkInRepository.getMaxCheckInDateByUserId(Integer.parseInt(id));

        return date;
    }
}
