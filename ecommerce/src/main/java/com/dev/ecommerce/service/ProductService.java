package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.ProductNotFoundException;
import com.dev.ecommerce.model.Product;
import com.dev.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private  final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(Long id){
        return productRepository.findById(id).orElseThrow( () -> new ProductNotFoundException("Product could not find by id:"+id));
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }









}
