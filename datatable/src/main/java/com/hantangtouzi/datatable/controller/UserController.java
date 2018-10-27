package com.hantangtouzi.datatable.controller;

import com.hantangtouzi.datatable.entity.User;
import com.hantangtouzi.datatable.result.DataTablePageInfo;
import com.hantangtouzi.datatable.result.PageInfo;
import com.hantangtouzi.datatable.result.PagedResultBean;
import com.hantangtouzi.datatable.result.ResultBean;
import com.hantangtouzi.datatable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 5:03 AM
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String index() {
        return "user/user.html";
    }

    @GetMapping("list")
    @ResponseBody
    public ResultBean<Collection<User>> list() {
        return new ResultBean<>(userService.findUsers());
    }

    @GetMapping("serverside")
    public String serverside() {
        return "user/serverside.html";
    }

    @GetMapping("server")
    @ResponseBody
    public PagedResultBean<Collection<User>> server(@RequestParam("start") Long start, @RequestParam("length") Long length,
                                                    @RequestParam("draw") Long draw,
                                                    @RequestParam(value = "recordsTotal", required = false) Long recordsTotal,
                                                    @RequestParam(value = "recordsFiltered", required = false) Long recordsFiltered) {
        PageInfo pageInfo = new DataTablePageInfo();
        ((DataTablePageInfo) pageInfo).setDraw(draw);
        ((DataTablePageInfo) pageInfo).setRecordsTotal(recordsTotal);
        ((DataTablePageInfo) pageInfo).setRecordsFiltered(recordsFiltered);
        pageInfo.setStart(start);
        pageInfo.setLength(length);

        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("length", length);
        List<User> users = userService.findUsers(map);

        if (recordsTotal == null) {
            recordsTotal = userService.getTotalCount(new HashMap<>());
        }

        if (recordsFiltered == null) {
            recordsFiltered = userService.getTotalCount(new HashMap<>());
        }

        return new PagedResultBean<>(users, draw, recordsTotal, recordsFiltered);
    }
}
