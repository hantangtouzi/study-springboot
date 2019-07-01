package com.hantangtouzi.security.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 20:35:04
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
