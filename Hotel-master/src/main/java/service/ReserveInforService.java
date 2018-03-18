package service;

import model.ReserveEntity;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/12.
 */
public interface ReserveInforService {

    List<ReserveEntity> getReserveInforById(String id);

    void deleteReserveInfor(int id);
}
