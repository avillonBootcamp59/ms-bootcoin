package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.entity.SellerUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SellerUserBcService {

    public Flux<SellerUser> findAll();
    public Mono<SellerUser> findById(String id);
    public Mono<SellerUser> save(SellerUser tasasBC);
    public Mono<Void> delete(SellerUser tasasBC);
}
