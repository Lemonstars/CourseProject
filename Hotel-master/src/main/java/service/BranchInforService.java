package service;

import model.RoomEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by starrylemon on 2017/3/9.
 */
public interface BranchInforService {

    Map<String,List> getBranchAddressInfor();

    List<RoomEntity> getBranchPriceInfor();
}
