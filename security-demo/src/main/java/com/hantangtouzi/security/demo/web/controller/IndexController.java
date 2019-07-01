package com.hantangtouzi.security.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 20:36:13
 */

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
