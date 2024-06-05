package com.testing.aws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Value("${beeceptor.base.url}")
    private String baseUrl;

    @Bean
    public WebClient.Builder webClientBuilder() {

        return WebClient.builder().baseUrl(baseUrl);

    }
}
