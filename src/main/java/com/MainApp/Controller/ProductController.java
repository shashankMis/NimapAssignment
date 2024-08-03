package com.MainApp.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MainApp.Entity.Product;
import com.MainApp.Service.ProductService;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @PostMapping
	 public Product createProduct(@RequestBody Product product) {
	     return productService.createProduct(product);
	 }
	 
	 @PutMapping("/{id}")
	 public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	     return productService.updateProduct(id, product);
	 }
	 
	 @DeleteMapping("/{id}")
	 public void deleteProduct(@PathVariable Long id) {
	     productService.deleteProduct(id);
	 }
	 
	 @GetMapping
	 public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
	                                        @RequestParam(defaultValue = "10") int size) {
	     return productService.getAllProducts(page, size);
	 }
	 
	 @GetMapping("/{id}")
	 public Optional<Product> getProductById(@PathVariable Long id) {
	     return productService.getProductById(id);
	 }
}
