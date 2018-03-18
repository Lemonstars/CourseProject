package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ApplyNewBranchService;

/**
 * Created by starrylemon on 2017/3/13.
 */


@Controller
public class ApplyNewBranchController {

    @Autowired
    ApplyNewBranchService applyNewBranchService;

    @RequestMapping(value = "/applyNewBranch")
    public String applyNewBranch(){
        return "applyNewBranch";
    }

    @RequestMapping(value = "/confirmApply",method = RequestMethod.POST)
    public String confirmApply(@RequestParam("applyName") String applyName, @RequestParam("icard")String icard,
                               @RequestParam("bank_number")String bank_number, @RequestParam("city")String city,
                               @RequestParam("address")String address, @RequestParam("numOfroom")String numOfroom,
                               @RequestParam("password1")String password1, @RequestParam("password2")String password2,
                               ModelMap modelMap){

        int keyNum=applyNewBranchService.applyNewBranch(applyName,icard,bank_number,city,address,numOfroom,password1,password2);
        modelMap.addAttribute("keyNum",keyNum);
        modelMap.addAttribute("applyName",applyName);
        modelMap.addAttribute("applyIcard",icard);
        modelMap.addAttribute("applyBankNum",bank_number);
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("address",address);
        modelMap.addAttribute("numOfRoom",numOfroom);
        return "applyInformation";
    }


}
