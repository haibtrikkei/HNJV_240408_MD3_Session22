package ra.rekkei.demo_springsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.rekkei.demo_springsecurity.security.CustomUserDetails;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping
    public String homeAdmin(Model model){
        CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user",user);
        return "admin";
    }
}
