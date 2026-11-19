package com.example.patrones.demo.controller;

import com.example.patrones.demo.dto.PurchaseOrderRequest;
import com.example.patrones.demo.statePattern.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/state-pattern")
public class StatePatternController {

    private final PurchaseService purchaseService;

    @PostMapping("/purchase-order")
    public String processPurchaseOrder(@RequestBody PurchaseOrderRequest request){
        return purchaseService.processPurchase(request);
    }
}
