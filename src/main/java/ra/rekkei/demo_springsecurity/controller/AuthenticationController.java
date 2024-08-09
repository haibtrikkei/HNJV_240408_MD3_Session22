package ra.rekkei.demo_springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {
    @RequestMapping("/home")
    public String home(Model model){
        return "home";
    }

    @RequestMapping(value = {"/","/login"})
    public String login(){
        return "login";
    }
}
