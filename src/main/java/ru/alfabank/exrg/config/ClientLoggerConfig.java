package ru.alfabank.exrg.config;

import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientLoggerConfig {

    @Bean
    Level feignLoggerLevel() {
        return Level.FULL;
    }
}
