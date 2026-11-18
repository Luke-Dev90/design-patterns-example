package com.example.patrones.demo.dto;

import lombok.Builder;

@Builder
public record PaymentDTO(
    String accountNumber,
    Double amount
){}
