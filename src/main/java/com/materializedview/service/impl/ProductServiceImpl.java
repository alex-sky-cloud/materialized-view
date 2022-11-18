package com.materializedview.service.impl;

import com.materializedview.model.Product;
import com.materializedview.repository.ProductRepository;
import com.materializedview.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void saveListProduct(List<Product> list) {

        productRepository.saveAll(list);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> getListProduct() {
        return productRepository.findAll();
    }
}
