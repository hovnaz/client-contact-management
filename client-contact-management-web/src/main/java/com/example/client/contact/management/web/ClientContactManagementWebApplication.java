package com.example.client.contact.management.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example.client.contact.management.core*", "com.example.client.contact.management.web*"})
@EnableJpaRepositories(basePackages = {"com.example.client.contact.management.core.repository"})
@EntityScan({"com.example.client.contact.management.core.entity"})
@SpringBootApplication
public class ClientContactManagementWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientContactManagementWebApplication.class, args);
    }

}
