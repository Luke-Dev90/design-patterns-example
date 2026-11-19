package com.example.patrones.demo.statePattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RejectState implements PurchaseOrderState {
    @Override
    public String getName() {
        return "REJECTED";
    }

    @Override
    public void reject(PurchaseOrder order) {
        log.info("Order {} is already rejected.", order.getOrderId());
    }

}
