package com.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigCors  implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Ajusta según las rutas de tu API
                .allowedOrigins("http://localhost:8095") // Origen del frontend (React)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*") // Permite todos los headers
                .allowCredentials(true); // Si tu API necesita enviar cookies o autenticación
    }
}
