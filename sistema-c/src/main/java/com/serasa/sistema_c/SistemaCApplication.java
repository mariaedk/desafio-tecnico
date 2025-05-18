package com.serasa.sistema_c;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Sistema C - API", version = "1.0"))
@SpringBootApplication
public class SistemaCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaCApplication.class, args);
	}

}
