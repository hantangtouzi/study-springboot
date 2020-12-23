package com.hantangtouzi.datasourcedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author WilliamChang.
 * Created on 2019-06-15 14:02:51
 */

@SpringBootApplication
public class DatasourceDemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DatasourceDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showConnection() throws SQLException {
        // log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        // log
        connection.close();
    }

    private void showData() {
        jdbcTemplate.queryForList("select * from t_foo").forEach(row -> System.out.println(row.toString()));
    }

}
