package ru.alfabank.exrg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableFeignClients
@EnableWebMvc
public class ExrgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExrgApplication.class, args);
	}

}
