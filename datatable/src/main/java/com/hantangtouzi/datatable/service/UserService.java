package com.hantangtouzi.datatable.service;

import com.hantangtouzi.datatable.entity.User;
import com.hantangtouzi.datatable.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 5:03 AM
 */

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getUserById(Long userId) {
        return userMapper.getUserById(userId);
    }

    public List<User> findUsers() {
        Map<String, Object> map = new HashMap<>();
        return userMapper.findUsers(map);
    }

    public List<User> findUsers(Map<String, Object> map) {
        return userMapper.findUsers(map);
    }

    public Long getTotalCount(Map<String, Object> map) {
        return userMapper.getTotalCount(map);
    }

}
