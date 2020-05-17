package com.hantangtouzi.security.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author WilliamChang.
 * Created on 2018/11/6 0:55
 */

@Controller
public class MainController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
    // @RequestMapping("/")
    // public String root() {
    //     return "redirect:/index";
    // }
    //
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
