package com.techlibrary.houseofbooks.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir qualquer origem (origins: "*")
        registry.addMapping("/**") // Aplica CORS em todas as rotas
                .allowedOrigins("*") // Permite todas as origens
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permite os métodos HTTP necessários
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true) // Permite credenciais (caso precise de autenticação)
                .maxAge(3600); // Tempo máximo que a configuração CORS pode ser armazenada no cache (em segundos)
    }
}
