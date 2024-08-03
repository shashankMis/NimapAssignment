package com.MainApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Product;
import com.MainApp.Repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
    
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    public Page<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

}
