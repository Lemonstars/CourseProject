package service;

/**
 * Created by starrylemon on 2017/3/11.
 */
public interface ReserveBranchService {

    void reserveBranch(String id, String branchId, String date, String payType, String roomType);

}
