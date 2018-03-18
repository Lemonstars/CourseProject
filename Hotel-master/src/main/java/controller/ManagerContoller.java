package controller;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ManageCountService;
import service.ManagerCheckService;
import vo.BranchCheckInVO;

import java.util.List;

@Controller
public class ManagerContoller {

    @Autowired
    ManagerCheckService managerCheckService;
    @Autowired
    ManageCountService manageCountService;

    //导航栏的controller
    @RequestMapping(value = "/manager-check")
    public String check(ModelMap modelMap){

        List<ApplyEntity> applyList=managerCheckService.getApplyList();
        List<ChangeInforEntity> changeInforList=managerCheckService.getChangeInforList();
        modelMap.addAttribute("applyList",applyList);
        modelMap.addAttribute("changeInforList",changeInforList);

        return "manager-check";
    }

    @RequestMapping(value = "/manager-balance")
    public String balance(ModelMap modelMap){
        List<CenterPayEntity> reserveList=manageCountService.getCenterPayReserveList();
        List<CenterPayEntity> consumeList=manageCountService.getCenterPayConsumeList();
        modelMap.addAttribute("reserveList", reserveList);
        modelMap.addAttribute("consumeList", consumeList);

        return "manager-balance";
    }

    @RequestMapping(value = "/manager-checkIn")
    public String checkIn(ModelMap modelMap){
        List<BranchCheckInVO> branchList=manageCountService.getBranchCheckInList();
        modelMap.addAttribute("branchList",branchList);
        return "manager-checkIn";
    }

    @RequestMapping(value = "/manager-finance")
    public String finance(ModelMap modelMap){
        String xData="[2016.1,2016.2,2016.3,2016.4,2016.5,2016.6," +
                "2016.7,2016.8,2016.9,2016.10," +
                "2016.11,2016.12,2017.1,2017.2,2017.3]";
        String yData=manageCountService.getConsumeNumPerMonth();

        modelMap.addAttribute("xData",xData);
        modelMap.addAttribute("yData",yData);

        return "manager-finance";
    }


    @RequestMapping(value = "/manager-member")
    public String member(ModelMap modelMap){
        List<ConsumeEntity> consumeList=manageCountService.getAllConsume();
        List<ReserveEntity> reserveList=manageCountService.getAllReserve();
        modelMap.addAttribute("consumeList",consumeList);
        modelMap.addAttribute("reserveList",reserveList);
        return "manager-member";
    }



    //申请的controller
    @RequestMapping(value = "/accpetApply")
    public String acceptApply(@RequestParam("applyID")String applyID){
        managerCheckService.acceptApplyBranch(applyID);
        return "redirect:/manager-check";
    }

    @RequestMapping(value = "/deleteApply")
    public String deleteApply(@RequestParam("applyID")String applyID){
        managerCheckService.deleteApplyBranch(applyID);
        return "redirect:/manager-check";
    }

    @RequestMapping(value = "/refuseApply")
    public String refuseApply(@RequestParam("applyID")String applyID){
        managerCheckService.refuseApplyBranch(applyID);
        return "redirect:/manager-check";
    }


    @RequestMapping(value = "/accpetChangeInfor")
    public String acceptChangeInfor(@RequestParam("changeID")String changeID){
        managerCheckService.acceptChangeInfor(changeID);
        return "redirect:/manager-check";
    }

    @RequestMapping(value = "/deleteChangeInfor")
    public String deleteChangeInfor(@RequestParam("changeID")String changeID){
        managerCheckService.delelteChangeInfor(changeID);
        return "redirect:/manager-check";
    }

    @RequestMapping(value = "/refuseChangeInfor")
    public String refuseChangeInfor(@RequestParam("changeID")String changeID){
        managerCheckService.refuseChangeInfor(changeID);
        return "redirect:/manager-check";
    }


    //结算部分controller
    @RequestMapping(value = "/deleteBalance")
    public String deleteBalance(@RequestParam("id") String id){
        manageCountService.deleteCenterPay(id);
        return "redirect:/manager-balance";
    }

    @RequestMapping(value = "/finalizeBalance")
    public String finalizeBalance(@RequestParam("id")String id){
        manageCountService.finalizeCenterPay(id);
        return "redirect:/manager-balance";
    }

    @RequestMapping(value = "/finalizeAllConsume")
    public String finalizeAllConsume(){
        manageCountService.finalizeAllCenterPay_Consume();
        return "redirect:/manager-balance";
    }

    @RequestMapping(value = "/finalizeAllReserve")
    public String finalizeAllReserve(){
        manageCountService.finalizeAllCenterPay_Reserve();
        return "redirect:/manager-balance";
    }

    @RequestMapping(value = "/deleteAllConsume")
    public String deleteAllConsume(){
        manageCountService.deleteAllCenterPay_Consume();
        return "redirect:/manager-balance";
    }

    @RequestMapping(value = "/deleteAllReserve")
    public String deleteAllReserve(){
        manageCountService.deleteAllCenterPay_Reserve();
        return "redirect:/manager-balance";
    }


}
