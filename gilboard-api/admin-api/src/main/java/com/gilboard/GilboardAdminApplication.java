package com.gilboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.gilboard")
@EntityScan("com.gilboard.domain.model")
@EnableJpaRepositories({"com.gilboard.domain.repository"})
public class GilboardAdminApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-admin-api");
        SpringApplication.run(GilboardAdminApplication.class, args);
    }
}
