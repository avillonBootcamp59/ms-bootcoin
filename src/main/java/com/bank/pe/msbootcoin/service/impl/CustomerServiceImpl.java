package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.entity.Customer;
import com.bank.pe.msbootcoin.CustomerConfig;
import com.bank.pe.msbootcoin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private CustomerConfig clientConfig;

    @Override
    public Flux<Customer> getAll() {
        return client.baseUrl(clientConfig.getUrl())
                .build()
                .get()
                .uri("/all")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Customer.class);
    }

    @Override
    public Mono<Customer> find(String id) {

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(clientConfig.getUrl())
                .build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Customer.class);
    }
}
