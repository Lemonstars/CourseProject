package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by starrylemon on 2017/3/6.
 */

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout")
    public String logout(){
        return "index";
    }
}
