package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.entity.Rates;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RatesService {

    public Flux<Rates> findAll();
    public Mono<Rates> findById(String id);
    public Mono<Rates> save(Rates rates);
    public Mono<Void> delete(Rates rates);
}
