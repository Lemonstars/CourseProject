package controller;

import model.CheckInEntity;
import model.ConsumeEntity;
import model.ReserveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;
import vo.BranchChangeInforVO;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    BranchPlanService branchPlanService;
    @Autowired
    BranchChangeInforService branchChangeInforService;
    @Autowired
    BranchCountService branchCountService;
    @Autowired
    BranchInforService branchinforser;
    @Autowired
    BranchRegisterInService branchRegisterInService;
    @Autowired
    BranchRegisterOutService branchRegisterOutService;


    @RequestMapping(value = "branch-plan")
    public String branch_plan(@RequestParam("id")String eid, ModelMap modelMap){
        List<Integer> result=branchPlanService.getRoomPrice(eid);
        int firstPrice=result.get(0);
        int secondPrice=result.get(1);
        int thirdPrice=result.get(2);

        modelMap.addAttribute("id",eid);
        modelMap.addAttribute("firstPrice",firstPrice);
        modelMap.addAttribute("scondPrice",secondPrice);
        modelMap.addAttribute("thirdPrice",thirdPrice);

        return "branch-plan";
    }

    @RequestMapping(value = "branch-registerIn")
    public String branch_registerIn(@RequestParam("id")String eid, ModelMap modelMap){
        Map<String,List> addressMap= branchinforser.getBranchAddressInfor();

        modelMap.addAttribute("id",eid);
        modelMap.addAttribute("addressMap",addressMap);
        return "branch-registerIn";
    }

    @RequestMapping(value = "branch-registerOut")
    public String branch_regiterOut(@RequestParam("id")String eid, ModelMap modelMap){
        Map<String,List> addressMap= branchinforser.getBranchAddressInfor();

        modelMap.addAttribute("id",eid);
        modelMap.addAttribute("addressMap",addressMap);

        return "branch-registerOut";
    }

    @RequestMapping(value = "branch-changeInfor")
    public String branch_changeInfor(@RequestParam("id")String eid, ModelMap modelMap){
        BranchChangeInforVO branchChangeInforVO=branchChangeInforService.getBranchInforByEid(eid);

        modelMap.addAttribute("id",eid);
        modelMap.addAttribute("icard",branchChangeInforVO.getIcard());
        modelMap.addAttribute("city" ,branchChangeInforVO.getCity());
        modelMap.addAttribute("address",branchChangeInforVO.getAddress());
        modelMap.addAttribute("numOfRoom",branchChangeInforVO.getNumOfRoom());
        return "branch-changeInfor";
    }

    @RequestMapping(value = "branch-count")
    public String branch_count(@RequestParam("id")String eid, ModelMap modelMap){
        int hid=branchCountService.getHidByEid(eid);

        List<ReserveEntity> reserveList=branchCountService.getReserveList(hid);
        List<ConsumeEntity> consumeList=branchCountService.getConsumeList(hid);
        List<CheckInEntity> checkInList=branchCountService.getCheckInList(hid);
        int[] numOfReserve=branchCountService.getReserveRoomNum(hid);
        int numOfReserve_1=numOfReserve[0];
        int numOfReserve_2=numOfReserve[1];
        int numOfReserve_3=numOfReserve[2];
        int[] numOfCheckIn=branchCountService.getCheckInRoomNum(hid);
        int numOfCheckIn_1=numOfCheckIn[0];
        int numOfCheckIn_2=numOfCheckIn[1];
        int numOfCheckIn_3=numOfCheckIn[2];
        double[] priceOfConsume=branchCountService.getConsumePriceNum(hid);
        double priceOfConsum1=priceOfConsume[0];
        double priceOfConsum2=priceOfConsume[1];
        double priceOfConsum3=priceOfConsume[2];

        modelMap.addAttribute("id",eid);
        modelMap.addAttribute("reserveList",reserveList);
        modelMap.addAttribute("consumeList",consumeList);
        modelMap.addAttribute("checkInList",checkInList);
        modelMap.addAttribute("numOfReserve1",numOfReserve_1);
        modelMap.addAttribute("numOfReserve2",numOfReserve_2);
        modelMap.addAttribute("numOfReserve3",numOfReserve_3);
        modelMap.addAttribute("numOfCheckIn1",numOfCheckIn_1);
        modelMap.addAttribute("numOfCheckIn2",numOfCheckIn_2);
        modelMap.addAttribute("numOfCheckIn3",numOfCheckIn_3);
        modelMap.addAttribute("priceOfConsume1",priceOfConsum1);
        modelMap.addAttribute("priceOfConsume2",priceOfConsum2);
        modelMap.addAttribute("priceOfConsume3",priceOfConsum3);
        return "branch-count";
    }


    //发布计划controller
    @RequestMapping(value = "/branch-changePlan")
    public String branch_changePlan(@RequestParam("id")String id,@RequestParam("price1")String price1,
                                    @RequestParam("price2")String price2,@RequestParam("price3")String price3){
        branchPlanService.setRoom1Price(id,price1);
        branchPlanService.setRoom2Price(id,price2);
        branchPlanService.setRoom3Price(id,price3);

        return "redirect:/branch-plan?id="+id;
    }

    //修改信息的controller
    @RequestMapping(value = "/branch-applyChangeInfor")
    public String branch_changeInfor(@RequestParam("id")String eid,@RequestParam("icard")String icard,
                                     @RequestParam("city")String city,@RequestParam("address")String address,
                                     @RequestParam("numOfRoom")String numOfRoom,@RequestParam("old_icard")String old_icard,
                                     @RequestParam("old_city")String old_city,@RequestParam("old_address")String old_address,
                                     @RequestParam("old_numOfRoom")String old_numOfRoom){

        branchChangeInforService.applyChangeBranchInfor(eid,icard,city,address,numOfRoom,old_icard,old_city,
                old_address,old_numOfRoom);

        return "redirect:/branch-plan?id="+eid;
    }

    //入住登记的controller
    @RequestMapping(value = "/branch-registerInfor")
    public String branch_registerInfor(@RequestParam("id")String eid,@RequestParam("aid")String aid,
                                       @RequestParam("hid")String hid, @RequestParam("roomType")String roomType){
        branchRegisterInService.register(aid,hid,roomType);

        return "redirect:/branch-plan?id="+eid;
    }

    //离店登记的controller
    @RequestMapping(value = "/branch_registerOutInfor")
    public String branch_registerOutInfor(@RequestParam("id")String eid,@RequestParam("aid")String aid,
                                          @RequestParam("hid")String hid,@RequestParam("pay_type")String pay_type,
                                          @RequestParam("room_type")String room_type,@RequestParam("price")String price){
        branchRegisterOutService.registerOut(aid,hid,pay_type,room_type,price);
        return "redirect:/branch-plan?id="+eid;
    }

}
