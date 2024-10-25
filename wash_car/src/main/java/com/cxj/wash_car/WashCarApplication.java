package com.cxj.wash_car;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cxj.wash_car.mapper")
public class WashCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(WashCarApplication.class, args);
    }

}
