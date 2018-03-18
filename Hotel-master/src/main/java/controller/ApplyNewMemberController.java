package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ApplyNewMemberService;

@Controller
public class ApplyNewMemberController {

    @Autowired
    ApplyNewMemberService applyNewMemberService;


    @RequestMapping(value = "/applyNewMember")
    public String applyNewMember(){
        return "applyNewMember";
    }

    @RequestMapping(value = "/confirmApplyMember")
    public String confirmApplyMember(@RequestParam("applyName")String name,
                                     @RequestParam("icard")String icard,
                                     @RequestParam("phone_number")String phone,
                                     @RequestParam("bank_number")String bank_Num,
                                     @RequestParam("bank_password")String bank_password,
                                     @RequestParam("isMember")String isMember,
                                     @RequestParam("password1")String password1,
                                     @RequestParam("password2")String password2,
                                     ModelMap modelMap){
        int aid=applyNewMemberService.applyNewMember(name,icard,phone,bank_Num,bank_password,
                isMember,password1,password2);

        modelMap.addAttribute("aid",aid);
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("icard",icard);
        modelMap.addAttribute("phone",phone);
        modelMap.addAttribute("bankNum",bank_Num);
        modelMap.addAttribute("isMember",isMember);
        return "applyMemberInformation";
    }

}
