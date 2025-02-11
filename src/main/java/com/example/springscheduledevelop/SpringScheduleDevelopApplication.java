package com.example.springscheduledevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringScheduleDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScheduleDevelopApplication.class, args);
    }

}
