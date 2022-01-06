package com.example.product_angular.service.product;

import com.example.product_angular.dto.ProductDTO;
import com.example.product_angular.model.Product;
import com.example.product_angular.service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    boolean existsByName(String nameProduct);
    Iterable<ProductDTO> findAllProductDTO();
}
