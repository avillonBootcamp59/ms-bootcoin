package com.bank.pe.msbootcoin.service;

import com.bank.pe.msbootcoin.dto.Account;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> findById(String id);
    Mono<Account> save(Account bankAccount);
}
