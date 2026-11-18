package com.example.patrones.demo.dto;

import lombok.Builder;

@Builder
public record TransferCommand (
        String channel,
        Double amount
){}
