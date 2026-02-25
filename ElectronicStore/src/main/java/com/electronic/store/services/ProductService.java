package com.electronic.store.services;

import com.electronic.store.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    // Create a new product
    ProductDto create(ProductDto productDto);

    // Update an existing product
    ProductDto update(ProductDto productDto, String productId);

    // Delete a product
    void delete(String productId);

    // Get a single product by ID
    ProductDto get(String productId);

    // Get all live products
    List<ProductDto> getAllLive();

    // Search products by title
    List<ProductDto> searchByTitle(String title);

    // Create a product with category
    ProductDto createWithCategory(ProductDto productDto, String categoryId);

    // Update category of a product
    ProductDto updateCategory(String productId, String categoryId);

    // Get all products of a category
    List<ProductDto> getAllOfCategory(String categoryId);

	List<ProductDto> getAllProducts();

	List<ProductDto> getAll();
}