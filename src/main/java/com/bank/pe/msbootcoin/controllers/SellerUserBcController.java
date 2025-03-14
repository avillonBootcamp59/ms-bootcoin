package com.bank.pe.msbootcoin.controllers;

import com.bank.pe.msbootcoin.entity.SellerUser;
import com.bank.pe.msbootcoin.service.SellerUserBcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/v1/sellerUserBc")
public class SellerUserBcController {
    final Logger logger = LoggerFactory.getLogger(SellerUserBcController.class);

    @Autowired
    private SellerUserBcService sellerUserBcService;

    @GetMapping("/all")
    public Flux<SellerUser> getAll(){
        return sellerUserBcService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<SellerUser> findTasasBC(@PathVariable String id){
        return sellerUserBcService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SellerUser> save(@RequestBody SellerUser clientMono){
        clientMono.setDateReg(LocalDate.now());
        return sellerUserBcService.save(clientMono);
    }

    @PutMapping("/{id}")
    public Mono<SellerUser> edit(@RequestBody SellerUser client, @PathVariable String id){
        return sellerUserBcService.findById(id).flatMap(c -> {
            c = client;

            return sellerUserBcService.save(c);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id){
        return sellerUserBcService.findById(id).flatMap(c -> {
            return sellerUserBcService.delete(c);
        });
    }
}
