package cn.zuijianren.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zuijianren
 * @date 2020/11/5 15:53
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/user/register")
    public String register(){
        return "register";
    }
}
