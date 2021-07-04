package com.j4v4developers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories
@EnableDiscoveryClient
public class TicketMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketMicroserviceApplication.class, args);
    }

}
