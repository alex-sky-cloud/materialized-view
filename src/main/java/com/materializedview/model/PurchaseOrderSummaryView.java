package com.materializedview.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "purchase_order_summary")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseOrderSummaryView {

    @Id
    private String state;

    private Double totalSale;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PurchaseOrderSummaryView that = (PurchaseOrderSummaryView) o;
        return state != null && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
