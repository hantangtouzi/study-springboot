package com.hantangtouzi.security.helloworld.dao;

import com.hantangtouzi.security.helloworld.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author WilliamChang.
 * Created on 2018/11/12 12:59
 */

@SpringBootTest
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void getUserByUsernameAndPasswordAndEnabled() {
        String username = "zhangsan";
        User user = userDao.getUserByUsernameAndPasswordAndEnabled(username);
        Assert.hasText("zhangsan", username);
    }
}
