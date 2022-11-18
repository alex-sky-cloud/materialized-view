package com.materializedview.service;

import com.materializedview.model.Product;

import java.util.List;

public interface ProductService {

   void saveListProduct(List<Product> list);

   List<Product> getListProduct();
}