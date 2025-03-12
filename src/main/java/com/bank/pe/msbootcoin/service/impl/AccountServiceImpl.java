package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.AccountConfig;
import com.bank.pe.msbootcoin.entity.Account;
import com.bank.pe.msbootcoin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private WebClient.Builder client;

    @Autowired
    private AccountConfig accountConfig;

    @Override
    public Mono<Account> findById(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return client.baseUrl(accountConfig.getUrl())
                .build()
                .get()
                .uri("/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Account.class);
    }

    @Override
    public Mono<Account> save(Account Account) {
        return client.baseUrl(accountConfig.getUrl())
                .build()
                .post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .syncBody(Account)
                .retrieve()
                .bodyToMono(Account.class);
    }

}
