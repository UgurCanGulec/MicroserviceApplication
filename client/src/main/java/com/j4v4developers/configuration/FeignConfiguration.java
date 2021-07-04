package com.j4v4developers.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.j4v4developers"})
public class FeignConfiguration {
}
