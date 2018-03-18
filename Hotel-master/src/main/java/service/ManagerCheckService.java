package service;


import model.ApplyEntity;
import model.ChangeInforEntity;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/15.
 */
public interface ManagerCheckService {

    List<ApplyEntity> getApplyList(   );

    List<ChangeInforEntity> getChangeInforList(  );

    void deleteApplyBranch(String id);

    void refuseApplyBranch(String id);

    void acceptApplyBranch(String id);

    void delelteChangeInfor(String id);

    void refuseChangeInfor(String id);

    void acceptChangeInfor(String id);
}
