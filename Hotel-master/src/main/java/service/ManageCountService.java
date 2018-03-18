package service;

import model.CenterPayEntity;
import model.ConsumeEntity;
import model.ReserveEntity;
import vo.BranchCheckInVO;

import java.util.List;

/**
 * Created by starrylemon on 2017/3/16.
 */


public interface ManageCountService {

    List<BranchCheckInVO> getBranchCheckInList();

    List<CenterPayEntity> getCenterPayConsumeList();

    List<CenterPayEntity> getCenterPayReserveList();

    void finalizeCenterPay(String id);

    void deleteCenterPay(String id);

    void finalizeAllCenterPay_Consume();

    void finalizeAllCenterPay_Reserve();

    void deleteAllCenterPay_Consume();

    void deleteAllCenterPay_Reserve();

    List<ConsumeEntity> getAllConsume();

    List<ReserveEntity> getAllReserve();

    String getConsumeNumPerMonth();

}
