package com.bank.pe.msbootcoin.controllers;

import com.bank.pe.msbootcoin.entity.Rates;
import com.bank.pe.msbootcoin.service.RatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api/v1/rates")
public class RatesController {
    final Logger logger = LoggerFactory.getLogger(RatesController.class);

    @Autowired
    private RatesService tasasBcService;

    @GetMapping("/all")
    public Flux<Rates> getAll(){
        return tasasBcService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Rates> findTasasBC(@PathVariable String id){
        return tasasBcService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Rates> save(@RequestBody Rates clientMono){

        logger.info("Registrando al TasasBC en la bd");
        clientMono.setDate(LocalDate.now());
        return tasasBcService.save(clientMono);
    }

    @PutMapping("/{id}")
    public Mono<Rates> edit(@RequestBody Rates client, @PathVariable String id){

        return tasasBcService.findById(id).flatMap(c -> {
            c.setTipoCambio(client.getTipoCambio());
            c.setTipo(client.getTipo());
            c.setFlag(client.getFlag());

            return tasasBcService.save(c);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable String id){
        return tasasBcService.findById(id).flatMap(c -> {
            return tasasBcService.delete(c);
        });
    }
}
