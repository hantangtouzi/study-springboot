package com.hantangtouzi.security.helloworld.dao;

import com.hantangtouzi.security.helloworld.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author WilliamChang.
 * Created on 2018/11/12 12:41
 */

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsernameAndPasswordAndEnabled(String username) {
        User user = jdbcTemplate.queryForObject("select * from t_user where username = ?", new Object[]{username}, new UserMapper());
        return user;
    }

    public User getUserByUsernameAndPasswordAndEnabled(String username, String password, boolean enabled) {
        return null;
    }

    private class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));
            return user;
        }
    }

}
