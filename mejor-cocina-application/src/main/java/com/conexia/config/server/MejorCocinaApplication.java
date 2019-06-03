package com.conexia.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("com.conexia")
@EntityScan("com.conexia")
@EnableJpaRepositories("com.conexia")
public class MejorCocinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MejorCocinaApplication.class, args);
    }
}

