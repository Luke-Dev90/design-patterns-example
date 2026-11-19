package com.example.patrones.demo.statePattern;

public class PendingState implements PurchaseOrderState{
    @Override
    public String getName() {
        return "PENDING";
    }

    @Override
    public void authorize(PurchaseOrder po) {
        po.changeState(new AuthorizedState());
    }

    @Override
    public void fail(PurchaseOrder po, String reason) {
        po.changeState(new FailState(reason));
    }

    @Override
    public void reject(PurchaseOrder po) {
        po.changeState(new RejectState());
    }
}
