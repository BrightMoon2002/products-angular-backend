package com.example.product_angular.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String name;
    @NotBlank
    @Size(min = 3, max = 500)
    private String avatarProduct;
    @NotBlank
    @Size(min = 3,  max = 10000)
    private String description;

    public Product(Long id, String name, String avatarProduct, String description) {
        this.id = id;
        this.name = name;
        this.avatarProduct = avatarProduct;
        this.description = description;
    }

    public Product() {
    }

    public Product(String name, String avatarProduct, String description) {
        this.name = name;
        this.avatarProduct = avatarProduct;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarProduct() {
        return avatarProduct;
    }

    public void setAvatarProduct(String avatarProduct) {
        this.avatarProduct = avatarProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
