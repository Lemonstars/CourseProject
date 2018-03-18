package service;


import vo.BranchChangeInforVO;

public interface BranchChangeInforService {

    BranchChangeInforVO getBranchInforByEid(String eid);

    void applyChangeBranchInfor(String eid,String icard,String city,String address, String numOfRoom,
                                String old_icard, String old_city, String old_address, String old_numOfRoom);
}
