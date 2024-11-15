package com.saveMoney.application;

        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for frontend URL and backend IP
        registry.addMapping("/**")
                .allowedOrigins("https://main.dq4ijv1k6d839.amplifyapp.com", "http://35.77.4.84/", "http://35.77.4.84:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
