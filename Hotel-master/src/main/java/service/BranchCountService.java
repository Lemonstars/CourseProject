package service;

import model.CheckInEntity;
import model.ConsumeEntity;
import model.ReserveEntity;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/18.
 */
public interface BranchCountService {

    int getHidByEid(String eid);

    List<ReserveEntity> getReserveList(int id);

    List<CheckInEntity> getCheckInList(int id);

    List<ConsumeEntity> getConsumeList(int id);
//
//    List<ReserveEntity> getReserveList();
//
//    List<CheckInEntity> getCheckInList();
//
//    List<ConsumeEntity> getConsumeList();

    int[] getReserveRoomNum(int hid);

    int[] getCheckInRoomNum(int hid);

    double[] getConsumePriceNum(int hid);

}
