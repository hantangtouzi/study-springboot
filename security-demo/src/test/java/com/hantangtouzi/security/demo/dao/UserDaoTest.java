package com.hantangtouzi.security.demo.dao;

import com.hantangtouzi.security.demo.SecurityDemoApplication;
import com.hantangtouzi.security.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author WilliamChang.
 * Created on 2019-07-01 22:14:52
 */

@SpringBootTest(classes = SecurityDemoApplication.class)
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findUserByUsername() {
        User user = userDao.findUserByUsername("zhangsan");
        System.out.println(user);
    }
}