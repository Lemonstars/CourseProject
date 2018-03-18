package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import service.MemberCheckService;

/**
 * Created by starrylemon on 2017/3/19.
 */

@Component
public class MemberSchedule {

    @Autowired
    MemberCheckService memberCheckService;

    @Scheduled(cron = "0 0 0 * * ?")
    public void checkMember(){
        memberCheckService.checkAllMember();
    }

}
