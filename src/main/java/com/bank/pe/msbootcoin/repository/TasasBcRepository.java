package com.bank.pe.msbootcoin.repository;

import com.bank.pe.msbootcoin.domain.TasasBc;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TasasBcRepository extends ReactiveMongoRepository<TasasBc, String> {
}
