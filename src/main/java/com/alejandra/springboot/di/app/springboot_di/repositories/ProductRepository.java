package com.alejandra.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import com.alejandra.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L, "Memoria corsair 32", 300L),
            new Product(2L, "Cpu Intel Core i9", 500L),
            new Product(3L, "Teclado Raczer Mini 60%", 180L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    };

    public List<Product> findAll() {
        return data;
    }
    
}
