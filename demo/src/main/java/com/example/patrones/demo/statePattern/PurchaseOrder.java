package com.example.patrones.demo.statePattern;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Slf4j
@Getter
public class PurchaseOrder {
    private final String orderId;
    private final BigDecimal amount;
    private PurchaseOrderState state;

    public PurchaseOrder(String id, BigDecimal amount){
        this.orderId = id;
        this.amount = amount;
        this.state = new PendingState();

    }

    void changeState(PurchaseOrderState newState){
        log.info("State changed from {} to {}", this.state.getName(), newState.getName());
        this.state = newState;
    }

}
