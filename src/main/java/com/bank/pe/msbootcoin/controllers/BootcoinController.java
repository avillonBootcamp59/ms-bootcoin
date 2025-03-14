package com.bank.pe.msbootcoin.controllers;

import com.bank.pe.msbootcoin.entity.BootcoinTransaction;
import com.bank.pe.msbootcoin.service.BootcointService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class BootcoinController {

    private final BootcointService bootcoinService;

    public BootcoinController(BootcointService bootcoinService) {
        this.bootcoinService = bootcoinService;
    }

    @PostMapping("/purchase")
    public String purchaseBootcoin(@RequestBody BootcoinTransaction transaction) {
        return bootcoinService.processPurchase(transaction);
    }
}