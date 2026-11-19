package com.example.patrones.demo.statePattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizedState implements PurchaseOrderState {
    @Override
    public String getName() {
        return "AUTHORIZED";
    }

    @Override
    public void purchase(PurchaseOrder order) {
        log.info("Processing authorized order: {}", order.getOrderId());
        order.changeState(new PurchaseState());
    }

    @Override
    public void fail(PurchaseOrder order, String reason) {
        log.info("Failing authorized order: {} Reason: {}", order.getOrderId(), reason);
        order.changeState(new FailState(reason));
    }

}
