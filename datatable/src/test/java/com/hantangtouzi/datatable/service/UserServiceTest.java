package com.hantangtouzi.datatable.service;

import com.hantangtouzi.datatable.DatatableApplication;
import com.hantangtouzi.datatable.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 5:42 AM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DatatableApplication.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        User user = userService.getUserById(1L);
        System.out.println(user);
    }
}
