package com.bank.pe.msbootcoin.entity;

import com.bank.pe.msbootcoin.dto.Customer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "sellerUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerUser {

    @Id
    private String id;
    private Customer customer;
    private LocalDate dateReg;
    private String idYanki;

}
