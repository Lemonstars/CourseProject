package service;

/**
 * Created by starrylemon on 2017/3/13.
 */


public interface ApplyNewBranchService {

    int applyNewBranch(String applyName,String icard,String bank_number,
                       String city,String address,String numOfRoom,
                       String password1,String password2);

}
