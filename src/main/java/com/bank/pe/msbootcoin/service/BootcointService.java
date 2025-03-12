package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.entity.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BootcointService {

    Flux<BootCoin> findAll();
    Mono<BootCoin> findById(String id);
    Mono<BootCoin> save(BootCoin wallet);
    Mono<Void> delete(BootCoin wallet);
}
