package com.bank.pe.msbootcoin.entity;

import com.bank.pe.msbootcoin.dto.Customer;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
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

    @BsonId
    private String id;
    private Customer customer;
    private LocalDate dateReg;
    private String idYanki;

}
