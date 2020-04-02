package com.hantangtouzi.simplejdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author WilliamChang.
 * Created on 2019-06-16 21:19:00
 */

@Slf4j
@Repository
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void insertData() {
        Arrays.asList("b", "c").forEach(bar -> {
            jdbcTemplate.update("insert into foo (bar) values (?)", bar);
        });

        HashMap<String, Object> row = new HashMap<>();
        row.put("BAR", "d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);

        System.out.println(id.longValue());
    }

    public void listData() {
        System.out.println("Count:" + jdbcTemplate.queryForObject("select count(*) from foo", Long.class));

        List<String> list = jdbcTemplate.queryForList("select bar from foo", String.class);
        list.forEach(s -> System.out.println(s));

        List<Foo> fooList = jdbcTemplate.query("select * from foo", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
                Foo foo = new Foo();
                foo.setId(rs.getLong(1));
                foo.setBar(rs.getString(2));
                return foo;
            }
        });

        fooList.forEach(f -> System.out.println(f));
    }

}
