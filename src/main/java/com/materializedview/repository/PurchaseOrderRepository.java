package com.materializedview.repository;


import com.materializedview.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
}
