package com.example.joinandlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JoinAndLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoinAndLoginApplication.class, args);
    }

}
