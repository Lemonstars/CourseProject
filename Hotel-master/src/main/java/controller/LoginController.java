package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.LoginService;

/**
 * Created by starrylemon on 2017/3/5.
 */

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("identify")String identify,
                        @RequestParam("id")String id,
                        @RequestParam("password")String password){
        String result="index";

        if(identify.equals("associator") && loginService.judgeAssociator(id,password)){
            result="redirect:/associator-reverse?id="+id;
        }else if(identify.equals("manager") && loginService.judgeManager(id,password)){
            result="redirect:/manager-check?id="+id;
        }else if (identify.equals("employee") && loginService.judgeEmployee(id,password)){
            result="redirect:/branch-plan?id="+id;
        }

        return result;
    }

}
