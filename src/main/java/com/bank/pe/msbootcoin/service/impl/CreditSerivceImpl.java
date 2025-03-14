package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.CreditConfig;
import com.bank.pe.msbootcoin.dto.Credit;
import com.bank.pe.msbootcoin.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreditSerivceImpl implements CreditService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private CreditConfig creditConfig;

    @Override
    public Mono<Credit> findById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(creditConfig.getUrl())
                .build()
                .get()
                .uri("/findBy/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Credit.class);
    }

    @Override
    public Mono<Credit> save(Credit Credit) {
        return client.baseUrl(creditConfig.getUrl())
                .build()
                .post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(Credit)
                .retrieve()
                .bodyToMono(Credit.class);
    }
}
