package com.electronic.store.services;

import java.util.List;

import com.electronic.store.dtos.CategoryDto;
import com.electronic.store.dtos.PageableResponse;

public interface CategoryService
{

    //create
    CategoryDto create(CategoryDto categoryDto);

    //update
    CategoryDto update(CategoryDto categoryDto, String categoryId);

    //delete

    void delete(String categoryId);

    //get single category detail
    CategoryDto get(String categoryId);

	List<CategoryDto> getAllCategories();

}
