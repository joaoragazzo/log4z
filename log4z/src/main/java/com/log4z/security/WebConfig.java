package com.log4z.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // ou use "/api/**" para ser mais específico
                .allowedOrigins("http://localhost:5173") // URL do seu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE") // ou use allowedMethods("*") para permitir todos os métodos
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}