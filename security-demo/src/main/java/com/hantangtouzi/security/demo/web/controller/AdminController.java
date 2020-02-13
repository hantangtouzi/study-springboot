package com.hantangtouzi.security.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 20:33:26
 */

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String list() {
        return "/admin/admin";
    }
}
