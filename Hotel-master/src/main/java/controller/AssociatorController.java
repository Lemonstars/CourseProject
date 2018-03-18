package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;

import java.util.List;
import java.util.Map;


/**
 * Created by starrylemon on 2017/3/6.
 */

@Controller
public class AssociatorController {

    @Autowired
    BranchInforService branchInforService;
    @Autowired
    ReserveBranchService reserveBranchService;
    @Autowired
    AssociatorInforService associatorInforService;

    @Autowired
    ReserveInforService reserveInforService;
    @Autowired
    ConsumeInforService consumeInforService;
    @Autowired
    CheckInInforService checkInInforService;



    @RequestMapping(value = "/associator-reverse")
    public String associator_reverse(String id, ModelMap modelMap){
        List<RoomEntity> roomList= branchInforService.getBranchPriceInfor();
        Map<String,List> addressMap=branchInforService.getBranchAddressInfor();
        modelMap.addAttribute("id",id);
        modelMap.addAttribute("addressMap",addressMap);
        modelMap.addAttribute("roomList",roomList);
        return "associator-reverse";
    }

    @RequestMapping(value = "/associator-unsubscribe")
    public String associator_unsubscribe(String id,ModelMap modelMap){
        List<ReserveEntity> reserveEntityList=reserveInforService.getReserveInforById(id);
        modelMap.addAttribute("id",id);
        modelMap.addAttribute("reserveList",reserveEntityList);
        return "associator-unsubscribe";
    }

    @RequestMapping(value = "/associator-information")
    public String associator_information(String id,ModelMap modelMap){
        List<ConsumeEntity> consumeList=consumeInforService.getConsumeInforByUser(id);
        List<CheckInEntity> checkInList=checkInInforService.getCheckInInforByUserId(id);
        List<ReserveEntity> reserveList=reserveInforService.getReserveInforById(id);
        double consumeSum=consumeInforService.getSumMoneyByUser(id);
        int numOfReserve=reserveList.size();
        String maxDate=checkInInforService.getMaxDateByUserId(id);

        modelMap.addAttribute("consumeList",consumeList);
        modelMap.addAttribute("checkInList",checkInList);
        modelMap.addAttribute("reserveList",reserveList);
        modelMap.addAttribute("consumeSum",consumeSum);
        modelMap.addAttribute("numOfReserve",numOfReserve);
        modelMap.addAttribute("maxDate",maxDate);
        modelMap.addAttribute("id",id);
        return "associator-information";
    }


    @RequestMapping(value = "/associator-modify")
    public String associator_modify(String id,ModelMap modelMap){
        AssociatorEntity associatorEntity=associatorInforService.getAssociatorInfor(Integer.parseInt(id));
        modelMap.addAttribute("userInfor",associatorEntity);
        modelMap.addAttribute("id",id);
        return "associator-modify";
    }


    //提交订单
    @RequestMapping(value = "/reverse",method = RequestMethod.POST)
    public String reverse(@RequestParam("id")String id,
                          @RequestParam("reverse_pay")String payType,
                          @RequestParam("reverse_type")String roomType,
                          @RequestParam("reverse_address")String address,
                          @RequestParam("reverse_date")String date, ModelMap modelMap){

        reserveBranchService.reserveBranch(id,address,date,payType,roomType);

        return "redirect:/associator-unsubscribe?id="+id;
    }

    //删除订单
    @RequestMapping(value = "/deleteReserve",method = RequestMethod.POST)
    public String deleteReserve(@RequestParam("orderId") String orderId,
                                @RequestParam("userId")String id){
        reserveInforService.deleteReserveInfor(Integer.parseInt(orderId));
        return "redirect:/associator-unsubscribe?id="+id;
    }

    //更新个人信息
    @RequestMapping(value = "/modifyUserInfor" ,method = RequestMethod.POST)
    public String modifyUserInfor(@RequestParam("id")String id, @RequestParam("userName")String userName,
                                  @RequestParam("userPhone")String userPhone, @RequestParam("userIcard")String userIcard,
                                  @RequestParam("password1")String password1,@RequestParam("password2")String password2,
                                  @RequestParam("isMember")String isMember){
        associatorInforService.modifyAssociatorInfor(id,userName,userIcard,userPhone,password1,password2,isMember);
        return "redirect:/associator-modify?id="+id;
    }

}
