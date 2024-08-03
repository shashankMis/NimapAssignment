package com.MainApp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Category;
import com.MainApp.Repository.CategoryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;
	
	public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
	
	public Category updateCategory(Long id, Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }
	
	public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
	
	public Page<Category> getAllCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size));
    }
	
	public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
