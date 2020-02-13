package com.hantangtouzi.security.helloworld.dao;

import com.hantangtouzi.security.helloworld.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author WilliamChang.
 * Created on 2018/11/12 12:59
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void getUserByUsernameAndPasswordAndEnabled() {
        String username = "zhangsan";
        User user = userDao.getUserByUsernameAndPasswordAndEnabled(username);
        Assert.assertEquals(username, user.getUsername());
    }
}
