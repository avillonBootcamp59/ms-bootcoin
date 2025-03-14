package com.bank.pe.msbootcoin.entity;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "rates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rates {

    @BsonId
    private String id;
    private LocalDate date;
    private double tipoCambio;
    private String tipo;
    private int flag;

}
