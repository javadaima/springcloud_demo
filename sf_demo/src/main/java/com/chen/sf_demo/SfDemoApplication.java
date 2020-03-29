package com.chen.sf_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.chen.sf_demo.*.dao")
@SpringBootApplication
public class SfDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfDemoApplication.class, args);
    }

}
