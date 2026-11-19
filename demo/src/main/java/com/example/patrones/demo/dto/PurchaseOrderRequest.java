package com.example.patrones.demo.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record PurchaseOrderRequest(
        String orderId,
        BigDecimal amount
) {
}
