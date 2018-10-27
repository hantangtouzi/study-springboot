package com.hantangtouzi.datatable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WilliamChang.
 * Created on 2018/10/14 4:41 AM
 */

@SpringBootApplication
@MapperScan("com.hantangtouzi.datatable.mapper")
public class DatatableApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DatatableApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }
}
