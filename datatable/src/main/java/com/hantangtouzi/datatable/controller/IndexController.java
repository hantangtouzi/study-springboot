package com.hantangtouzi.datatable.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 4:56 AM
 */

@Controller
public class IndexController {
    @GetMapping
    public String index() {
        return "index";
    }
}
