package com.materializedview.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PurchaseOrderSummaryViewDto {

    private String state;

    private double totalSale;
}
