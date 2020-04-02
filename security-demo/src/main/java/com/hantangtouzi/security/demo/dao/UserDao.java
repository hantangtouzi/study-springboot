package com.hantangtouzi.security.demo.dao;

import com.hantangtouzi.security.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author WilliamChang.
 * Created on 2019-07-01 22:08:30
 */

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        List<User> users = jdbcTemplate.query(sql, new Object[]{username}, new UserRowMapper());
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            return user;
        }
    }

}
