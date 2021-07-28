package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.CreateProductDto;
import com.dev.ecommerce.dto.CreateProductMapper;
import com.dev.ecommerce.dto.ProductDto;
import com.dev.ecommerce.dto.ProductMapper;
import com.dev.ecommerce.model.Product;
import com.dev.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;
    private final CreateProductMapper createProductMapper;

    public ProductController(ProductService productService, ProductMapper productMapper, CreateProductMapper createProductMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
        this.createProductMapper = createProductMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts(){
        return ResponseEntity.ok(productMapper.toListProductsDto(productService.findAllProducts()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id){
        Optional<ProductDto> product = Optional.ofNullable(productMapper.toProduct(productService.findProductById(id)));
        return ResponseEntity.ok(product.get());
    }

    @PostMapping
    public ResponseEntity<CreateProductDto> createProduct (@RequestBody ProductDto productDto){
        productService.saveProduct(productMapper.toProductDto(productDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(createProductMapper.toCreateProductDto(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
        Product product = productMapper.toProductDto(productDto);
        product.setId(id);
        productService.saveProduct(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDto);
    }

}
