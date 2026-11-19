package com.example.patrones.demo.statePattern;

import com.example.patrones.demo.dto.PurchaseOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PurchaseService {
    List<String> unableOrderList = List.of("QQQ", "AMZ");

    public String processPurchase(PurchaseOrderRequest request) {
        PurchaseOrder order = new PurchaseOrder(request.orderId(), request.amount());
        try {
            // Simulate processing the purchase order
            log.info("Processing purchase order: {} with amount: {}", request.orderId(), request.amount());

            if(unableOrderList.contains(request.orderId())) {
                order.getState().fail(order , "Order ID is in the unable list");
                return "Purchase order failed: Order ID is in the unable list";
            }

            // Simulate some processing logic with minimum amount check
            if (order.getAmount().compareTo(new java.math.BigDecimal("1000")) > 0) {
                order.getState().authorize(order);
            } else if (order.getAmount().compareTo(new java.math.BigDecimal("1000")) <= 0) {
                order.getState().reject(order);
                return "Purchase order rejected: Amount is below the minimum required";
            }

            Thread.sleep(1000); // Simulate a delay of 1 second

            if(order.getState().getName().equals("AUTHORIZED")) {
                order.getState().purchase(order);
            }

        } catch (InterruptedException e) {
            log.error("Error processing purchase order {}", order.getOrderId(), e);
        }
        return "Purchase order processed successfully.";
    }
}
