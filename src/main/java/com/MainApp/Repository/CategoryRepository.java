package com.MainApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MainApp.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
