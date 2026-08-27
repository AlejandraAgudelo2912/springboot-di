package com.alejandra.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alejandra.springboot.di.app.springboot_di.models.Product;

//@Primary
//es para indicar cuando hay mas de una implementacion de un bean, cual es la que se va a inyectar por defecto
@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(1L, "Monitor Asus 27", 600L);
    }

}
