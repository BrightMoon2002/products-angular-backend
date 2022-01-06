package com.example.product_angular.service.product;

import com.example.product_angular.dto.ProductDTO;
import com.example.product_angular.model.Product;
import com.example.product_angular.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public boolean existsByName(String nameProduct) {
        return productRepository.existsByName(nameProduct);
    }

    @Override
    public Iterable<ProductDTO> findAllProductDTO() {
        return productRepository.findAllProductDTO();
    }
}
