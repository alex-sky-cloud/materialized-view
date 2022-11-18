package com.materializedview.controller;

import com.materializedview.dto.PurchaseOrderSummaryViewDto;
import com.materializedview.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("purchase")
@RequiredArgsConstructor
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;

    @PostMapping("/sale/{userIndex}/{prodIndex}")
    public void placeOrder(@PathVariable final int userIndex,
                           @PathVariable final int prodIndex){
        this.purchaseOrderService.createOrderUser(userIndex, prodIndex);
    }

    @GetMapping("/summary")
    public List<PurchaseOrderSummaryViewDto> getSummary(){
        return this.purchaseOrderService.getSaleSummary();
    }

}
