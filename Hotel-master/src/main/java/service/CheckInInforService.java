package service;

import model.CheckInEntity;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */
public interface CheckInInforService {

    List<CheckInEntity> getCheckInInforByUserId(String id);

    String getMaxDateByUserId(String id);
}
