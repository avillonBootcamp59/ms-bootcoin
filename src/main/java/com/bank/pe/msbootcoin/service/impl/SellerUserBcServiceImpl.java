package com.bank.pe.msbootcoin.service.impl;

import com.bank.pe.msbootcoin.domain.SellerUser;
import com.bank.pe.msbootcoin.repository.SellerUserBcRepository;
import com.bank.pe.msbootcoin.service.SellerUserBcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class SellerUserBcServiceImpl implements SellerUserBcService {

  @Autowired
  private SellerUserBcRepository sellerUserBcRepository;

  @Override
  public Flux<SellerUser> findAll() {
    return sellerUserBcRepository.findAll();
  }

  @Override
  public Mono<SellerUser> findById(String id) {
    return sellerUserBcRepository.findById(id);
  }

  @Override
  public Mono<SellerUser> save(SellerUser tasasBC) {
    return sellerUserBcRepository.save(tasasBC);
  }

  @Override
  public Mono<Void> delete(SellerUser tasasBC) {
    return sellerUserBcRepository.delete(tasasBC);
  }

}
