package com.hantangtouzi.datatable.mapper;

import com.hantangtouzi.datatable.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 4:50 AM
 */

public interface UserMapper {
    User getUserById(Long userId);

    List<User> findUsers(Map<String, Object> map);

    Long getTotalCount(Map<String, Object> map);
}
