package com.gilboard.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.gilboard.domain.model")
@EnableJpaRepositories("com.gilboard.domain.repository")
public class GilboardApiApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-api");
        SpringApplication.run(GilboardApiApplication.class, args);
    }

}
