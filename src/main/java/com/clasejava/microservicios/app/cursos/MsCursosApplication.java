package com.clasejava.microservicios.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCursosApplication.class, args);
	}

}
