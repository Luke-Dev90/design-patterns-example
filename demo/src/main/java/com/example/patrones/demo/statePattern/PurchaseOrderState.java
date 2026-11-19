package com.example.patrones.demo.statePattern;

public interface PurchaseOrderState {
    String getName();
    default void authorize(PurchaseOrder po ){
        throw new IllegalStateException("No se puede AUTORIZAR una transacción en estado: " + getName());
    }
    default void reject(PurchaseOrder po ){
        throw new IllegalStateException("No se puede RECHAZAR una transacción en estado: " + getName());
    }
    default void purchase(PurchaseOrder po ){
        throw new IllegalStateException("No se puede COMPRAR una transacción en estado: " + getName());
    }
    default void fail(PurchaseOrder po , String reason) {
        throw new IllegalStateException("No se puede marcar como FALLIDA en estado: " + getName());
    }
}
