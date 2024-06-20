package org.mongodb.service;

import org.bson.types.ObjectId;
import org.mongodb.dto.CategoryDto;
import org.mongodb.dto.CategoryRequestDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryRequestDto request);
    List<CategoryDto> getListCategory();
    CategoryDto getCategoryById(ObjectId id);
    CategoryDto updateCategory(ObjectId id, CategoryRequestDto request);
    void updateStatusCategory(ObjectId id);
}
