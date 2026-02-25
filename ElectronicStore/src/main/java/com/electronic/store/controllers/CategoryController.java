package com.electronic.store.controllers;

import com.electronic.store.dtos.ApiResponseMessage;
import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.dtos.ProductDto;
import com.electronic.store.services.CategoryService;
import com.electronic.store.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    // Create a category
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto created = categoryService.create(categoryDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // Update a category
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable String categoryId,
            @RequestBody CategoryDto categoryDto
    ) {
        CategoryDto updated = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // Delete a category
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponseMessage> deleteCategory(@PathVariable String categoryId) {
        categoryService.delete(categoryId);
        ApiResponseMessage response = ApiResponseMessage.builder()
                .message("Category deleted successfully !!")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get all categories (paginated in service if needed)
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    // Get single category
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String categoryId) {
        CategoryDto categoryDto = categoryService.get(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    // Create product with category
    @PostMapping("/{categoryId}/products")
    public ResponseEntity<ProductDto> createProductWithCategory(
            @PathVariable String categoryId,
            @RequestBody ProductDto dto
    ) {
        ProductDto createdProduct = productService.createWithCategory(dto, categoryId);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Update category of a product
    @PutMapping("/{categoryId}/products/{productId}")
    public ResponseEntity<ProductDto> updateCategoryOfProduct(
            @PathVariable String categoryId,
            @PathVariable String productId
    ) {
        ProductDto updatedProduct = productService.updateCategory(productId, categoryId);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Get all products of a category (List, not pageable)
    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<ProductDto>> getProductsOfCategory(@PathVariable String categoryId) {
        List<ProductDto> products = productService.getAllOfCategory(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}