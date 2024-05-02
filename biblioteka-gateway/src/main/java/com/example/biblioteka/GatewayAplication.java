package com.example.biblioteka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayAplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayAplication.class, args);
    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("biblioteka-library", route -> route
                        .path("/api/libraries/{libraryId}")
                        .or()
                        .path("/api/libraries")
                        .uri("http://localhost:8082"))
                .route("biblioteka-book", route -> route
                        .path("/api/books")
                        .or()
                        .path("/api/books/**")
                        .or()
                        .path("/api/libraries/{libaryId}/books")
                        .or()
                        .path("/api/libaries/{libaryId}/books/**")
                        .uri("http://localhost:8081"))
                .build();
    }
}