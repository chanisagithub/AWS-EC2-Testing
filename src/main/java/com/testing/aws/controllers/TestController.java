package com.testing.aws.controllers;


import com.testing.aws.dto.crudResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final WebClient.Builder webClientBuilder;

    @PostMapping
    public Mono<String> addUser(@RequestBody crudResponses user) {
        return webClientBuilder.
                build().
                post().
                uri("/api/test").
                bodyValue(user).
                retrieve().
                bodyToMono(String.class);
    }

    @GetMapping
    public Mono<String> getUser() {
        return webClientBuilder.
                build().
                get().
                uri("/api/test").
                retrieve().
                bodyToMono(String.class);
    }
}
