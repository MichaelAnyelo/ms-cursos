package com.clasejava.microservicios.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.clasejava.microservicios.app.commons.alumnos.models.entity",
			 "com.clasejava.microservicios.app.cursos.models.entity"})
public class MsCursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCursosApplication.class, args);
	}

}
