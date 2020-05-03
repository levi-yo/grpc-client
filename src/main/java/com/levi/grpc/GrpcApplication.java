package com.levi.grpc;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class GrpcApplication {

    private final GrpcClient grpcClient;

    public static void main(String[] args) {
        SpringApplication.run(GrpcApplication.class, args);
    }

    @GetMapping("/")
    public Mono<String> test() {
        return Mono.just(grpcClient.sampleCall());
    }

}
