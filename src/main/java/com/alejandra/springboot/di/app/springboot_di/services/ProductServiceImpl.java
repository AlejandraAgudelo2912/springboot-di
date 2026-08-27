package com.alejandra.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alejandra.springboot.di.app.springboot_di.models.Product;
import com.alejandra.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    //@Autowired
    //@Qualifier("productFoo")
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
         this.repository = repository;
    }
    //el qualifier es para indicar cual de las implementaciones de un bean se va a inyectar, en este caso la que tiene el nombre productList, que es la de ProductRepositoryImpl

    @Override
    public List<Product> findAll(){
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            // Product newProd = new Product(p.getId(),p.getName(),priceImp.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            //p.setPrice(priceTax.longValue());
            // return p;
            return newProd;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }

}
