package com.example.product_angular.repository;

import com.example.product_angular.dto.ProductDTO;
import com.example.product_angular.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String nameProduct);
    @Query(value = "select id as id, avatar_product as avatar, description as descriptionProduct, name as name, date_of_manufacture as date, price as price from products", nativeQuery = true)
    Iterable<ProductDTO> findAllProductDTO();

}
