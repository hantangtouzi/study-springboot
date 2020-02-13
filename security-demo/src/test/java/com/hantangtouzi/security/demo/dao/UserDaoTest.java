package com.hantangtouzi.security.demo.dao;

import com.hantangtouzi.security.demo.SecurityDemoApplication;
import com.hantangtouzi.security.demo.config.DataConfig;
import com.hantangtouzi.security.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 22:14:52
 */

@RunWith(SpringRunner.class)
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