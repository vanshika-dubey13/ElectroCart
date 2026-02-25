package com.electronic.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.electronic.store.entities.Category;
import com.electronic.store.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    
    // Search products by title
    List<Product> findByTitleContaining(String subTitle);

    // Get all live products
    List<Product> findByLiveTrue();

    // Get products by category
    List<Product> findByCategory(Category category);
}