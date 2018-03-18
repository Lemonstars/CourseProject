package service.implement;

import model.CheckInEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CheckInRepository;
import service.BranchRegisterInService;
import util.MyDate;

import java.sql.Date;

@Service
public class BranchRegisterServiceImp implements BranchRegisterInService{

    @Autowired
    CheckInRepository checkInRepository;

    @Override
    public void register(String aid, String hid, String roomType) {
        String today= MyDate.getInstance().getTodayDate();
        Date today_sql=Date.valueOf(today);

        CheckInEntity checkInEntity=new CheckInEntity();
        checkInEntity.setAid(Integer.parseInt(aid));
        checkInEntity.setHid(Integer.parseInt(hid));
        checkInEntity.setTime(today_sql);
        checkInEntity.setRoomType(roomType);

        checkInRepository.saveAndFlush(checkInEntity);
    }
}
