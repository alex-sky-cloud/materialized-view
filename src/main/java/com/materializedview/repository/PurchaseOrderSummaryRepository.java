package com.materializedview.repository;


import com.materializedview.model.PurchaseOrderSummaryView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummaryView, String> {
}
