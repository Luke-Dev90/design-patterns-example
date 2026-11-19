package com.example.patrones.demo.statePattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record FailState(String reason) implements PurchaseOrderState {
    public FailState {
        log.info("FailState created with reason: {}", reason);
    }

    @Override
    public String getName() {
        return "FAIL";
    }

}
