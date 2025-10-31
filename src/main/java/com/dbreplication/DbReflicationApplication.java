package com.dbreplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DbReflicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbReflicationApplication.class, args);
    }

}
