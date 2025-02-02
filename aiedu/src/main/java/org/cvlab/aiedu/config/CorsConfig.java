package org.cvlab.aiedu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    static final String[] ORIGINS = new String[] { "GET", "POST", "PUT", "DELETE" };

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/audio/stream").allowedOriginPatterns("*")
                .allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
    }
}
