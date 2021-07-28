package com.dev.ecommerce.service;

import com.dev.ecommerce.model.Product;
import com.dev.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;

    Product product = new Product((long)1,"Orange",5.5);

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productRepository);
    }

    @Test
    public void testFindProductById_whenProductIdExist_shouldReturnProduct(){
        Mockito.when(productRepository.findById((long)1)).thenReturn(Optional.of(product));

        Product result = productService.findProductById((long)1);

        Assertions.assertEquals(product, result);
    }

    @Test
    public void testFindAllProducts_shouldReturnProductList(){
        List<Product> newProducts = new ArrayList<>();
        Product product1 = new Product((long)2,"Banana", 16.5);
        Product product2 = new Product((long)2,"Peach", 4.0);
        Product product3 = new Product((long)3,"Apple", 3.6);

        newProducts.add(product1);
        newProducts.add(product2);
        newProducts.add(product3);

        Mockito.when(productRepository.findAll()).thenReturn(newProducts);

        List<Product> result = productService.findAllProducts();

        Assertions.assertEquals(newProducts, result);
    }

    @Test
    public void testSaveProduct_whenSaveProductCalledWithValidRequest_itShouldReturnValidProduct(){
        Mockito.when(productRepository.save(product)).thenReturn(product);

        Product result = productService.saveProduct(product);

        Assertions.assertEquals(product, result);
    }
}