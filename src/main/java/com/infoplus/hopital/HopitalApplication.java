package com.infoplus.hopital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class HopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HopitalApplication.class, args);
    }

}
