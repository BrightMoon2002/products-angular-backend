package com.example.product_angular.controller;

import com.example.product_angular.dto.ProductDTO;
import com.example.product_angular.dto.response.ResponseMessage;
import com.example.product_angular.model.Product;
import com.example.product_angular.service.product.IProductService;
import com.example.product_angular.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> showListProduct() {
        Iterable<Product> products = productService.findAll();
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewProduct(@RequestBody Product product) {
        if (productService.existsByName(product.getName())) {
            return new ResponseEntity<>(new ResponseMessage("name_product_exist"), HttpStatus.OK);
        }
        if (product.getAvatarProduct() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_avatar_product"), HttpStatus.OK);
        }
        if (product.getPrice() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_price_product"), HttpStatus.OK);
        }
        if (product.getDescription() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_description_product"), HttpStatus.OK);
        }
        if (product.getDateOfManufacture() == null) {
            return new ResponseEntity<>(new ResponseMessage("no_date_product"), HttpStatus.OK);
        }
        productService.save(product);
        return new ResponseEntity<>(new ResponseMessage("successful"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showDetailProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(new ResponseMessage("no_product_id"), HttpStatus.OK);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (productService.existsByName(product.getName())) {
            if (!product.getAvatarProduct().equals(productOptional.get().getAvatarProduct())) {
                productOptional.get().setAvatarProduct(product.getAvatarProduct());
                productService.save(productOptional.get());
                return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
            }
            return new ResponseEntity<>(new ResponseMessage("no_name_category"), HttpStatus.OK);
        }
        productOptional.get().setAvatarProduct(product.getName());
        productOptional.get().setAvatarProduct(product.getAvatarProduct());
        productService.save(productOptional.get());
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
}








