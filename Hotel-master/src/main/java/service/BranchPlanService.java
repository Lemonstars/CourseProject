package service;


import java.util.List;

/**
 * Created by starrylemon on 2017/3/18.
 */
public interface BranchPlanService  {


    List<Integer> getRoomPrice(String eid);

    void setRoom1Price(String eid,String price);

    void setRoom2Price(String eid,String price);

    void setRoom3Price(String eid,String price);

}
