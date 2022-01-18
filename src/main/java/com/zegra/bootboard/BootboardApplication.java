package com.zegra.bootboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootboardApplication.class, args);
    }

}
