package com.app.demo.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.demo.entity.CambioData;

import reactor.core.publisher.Mono;

@Service
public class CambioService {
    
    @Autowired
    WebClient webClient;

    public Mono<Float> getExchangeRate(String origin, String destination){
        return webClient.get()
                .uri(uriBuelder -> uriBuelder
                    .path("/latest")
                    .queryParam("from", origin)
                    .queryParam("to", destination)
                    .build())
                .retrieve()
                .bodyToMono(CambioData.class)
                .map(data -> data.getRates().get(destination))
                .timeout(Duration.ofMillis(10_000));
    }
}
