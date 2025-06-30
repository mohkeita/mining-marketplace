package io.mohkeita.mining_marketplace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud_name}")
    String cloudName;
    @Value("${cloudinary.api_key}")
    String apiKey;
    @Value("${cloudinary.api_secret}")
    String apiSecret;

    @Bean
    public com.cloudinary.Cloudinary cloudinary() {
        Map<String, String> config = Map.of(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        );
        return new com.cloudinary.Cloudinary(config);
    }
}
