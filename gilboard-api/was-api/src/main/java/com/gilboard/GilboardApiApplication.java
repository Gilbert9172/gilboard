package com.gilboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.gilboard.was", "com.gilboard.domain, com.gilboard.infra"})
@EntityScan("com.gilboard.domain")
@EnableJpaRepositories({"com.gilboard.infra"})
public class GilboardApiApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-api");
        SpringApplication.run(GilboardApiApplication.class, args);
    }
}
