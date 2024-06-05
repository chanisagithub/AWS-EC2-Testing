package com.testing.aws.controllers;


import com.testing.aws.dto.crudResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private final WebClient.Builder webClientBuilder;

    @PostMapping
    public Mono<String> addUser(@RequestBody crudResponses user) {

        return webClientBuilder.
                build().
                post().
                uri("/api/test").
                bodyValue(user).
                retrieve().
                bodyToMono(String.class)
                .doOnSuccess(res -> logger.info("Response: {}", res))
                .doOnError(error -> logger.error("Error: ", error));
    }

    @GetMapping
    public Mono<String> getUser() {
        return webClientBuilder.
                build().
                get().
                uri("/api/test").
                retrieve().
                bodyToMono(String.class)
                .doOnSuccess(res -> logger.info("Response: {}", res))
                .doOnError(error -> logger.error("Error: ", error));
    }
}
