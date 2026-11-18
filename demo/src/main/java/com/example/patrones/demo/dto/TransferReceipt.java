package com.example.patrones.demo.dto;

import lombok.Builder;

@Builder
public record TransferReceipt (
    String transferChannel,
    Double amount,
    String message
){

}
