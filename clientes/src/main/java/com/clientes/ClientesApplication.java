package com.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("http://localhost:3000") // Ajusta según las rutas de tu API
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
						.allowedHeaders("*") // Permite todos los headers
						.allowCredentials(true); // Si tu API necesita enviar cookies o autenticación;
			}
		};
	}



}
