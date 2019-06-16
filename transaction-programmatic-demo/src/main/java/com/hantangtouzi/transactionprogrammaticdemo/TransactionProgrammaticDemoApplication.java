package com.hantangtouzi.transactionprogrammaticdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author WilliamChang.
 * Created on 2019-06-16 21:56:59
 */

@SpringBootApplication
public class TransactionProgrammaticDemoApplication implements CommandLineRunner {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(TransactionProgrammaticDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Count before transaction: " + getCount());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                jdbcTemplate.execute("insert into foo(id, bar) values (1, 'aaa')");
                System.out.println("Count in transaction: " + getCount());
                status.setRollbackOnly();
            }
        });
        System.out.println("Count after transaction: " + getCount());
    }

    private long getCount() {
        return (long) jdbcTemplate.queryForList("select count(*) as cnt from foo").get(0).get("cnt");
    }
}
