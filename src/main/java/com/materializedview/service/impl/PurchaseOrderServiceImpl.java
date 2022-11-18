package com.materializedview.service.impl;


import com.materializedview.dto.PurchaseOrderSummaryViewDto;
import com.materializedview.model.Product;
import com.materializedview.model.PurchaseOrder;
import com.materializedview.model.User;
import com.materializedview.repository.ProductRepository;
import com.materializedview.repository.PurchaseOrderRepository;
import com.materializedview.repository.PurchaseOrderSummaryRepository;
import com.materializedview.repository.UserRepository;
import com.materializedview.service.PurchaseOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final PurchaseOrderSummaryRepository purchaseOrderSummaryRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final PurchaseOrderRepository purchaseOrderRepository;

    private List<User> users;
    private List<Product> products;

    @PostConstruct
    private void init(){
        this.users = this.userRepository.findAll();
        this.products = this.productRepository.findAll();
    }

    @Override
    public void createOrderUser(int userIndex, int productIndex) {

        PurchaseOrder purchaseOrder = new PurchaseOrder();

        Product product = this.products.get(productIndex);
        Long productId = product.getId();

        User user = this.users.get(userIndex);
        Long userId = user.getId();

        purchaseOrder.setProductId(productId);
        purchaseOrder.setUserId(userId);

        this.purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public List<PurchaseOrderSummaryViewDto> getSaleSummary() {

        return this.purchaseOrderSummaryRepository.findAll()
                        .stream()
                        .map(pos -> {
                            PurchaseOrderSummaryViewDto dto = new PurchaseOrderSummaryViewDto();
                            dto.setState(pos.getState());
                            dto.setTotalSale(pos.getTotalSale());
                            return dto;
                        })
                        .toList();
    }

    @Override
    public void saveListPurchaseOrder(List<PurchaseOrder> list) {
        purchaseOrderRepository.saveAll(list);
    }
}
