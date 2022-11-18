package com.materializedview.service;


import com.materializedview.dto.PurchaseOrderSummaryViewDto;
import com.materializedview.model.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {

    void createOrderUser(int userIndex, int productIndex);

    List<PurchaseOrderSummaryViewDto> getSaleSummary();

    void saveListPurchaseOrder(List<PurchaseOrder> list);
}
