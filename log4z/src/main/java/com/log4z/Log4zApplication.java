package com.log4z;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Log4zApplication {

    public static void main(String[] args) {
        SpringApplication.run(Log4zApplication.class, args);
    }

}
