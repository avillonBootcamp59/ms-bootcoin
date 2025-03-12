package com.bank.pe.msbootcoin.repository;

import com.bank.pe.msbootcoin.domain.SellerUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SellerUserBcRepository extends ReactiveMongoRepository<SellerUser, String> {
}
