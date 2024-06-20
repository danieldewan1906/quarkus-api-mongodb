package org.mongodb.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import org.bson.types.ObjectId;
import org.mongodb.dto.CategoryDto;
import org.mongodb.dto.CategoryRequestDto;
import org.mongodb.entity.Category;
import org.mongodb.repository.CategoryRepository;
import org.mongodb.service.CategoryService;

import java.util.Date;
import java.util.List;

@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private ObjectMapper mapper;

    @Override
    public CategoryDto createCategory(CategoryRequestDto request) {
        System.out.println(request);
        Category category = new Category();
        category.setName(request.name());
        category.setIsActive(true);
        category.setCreatedAt(new Date());

        categoryRepository.saveCategory(category);
        return new CategoryDto(null, category.getName(), category.getIsActive(), category.getCreatedAt(), category.getUpdatedAt());
    }

    @Override
    public List<CategoryDto> getListCategory() {
        List<Category> categories = categoryRepository.list("isActive", true);
        List<CategoryDto> categoryDtos = categories.stream().map(data -> mapper.convertValue(data, CategoryDto.class)).toList();
        return categoryDtos;
    }

    @Override
    public CategoryDto getCategoryById(ObjectId id) {
        Category category = categoryRepository.findById(id);
        CategoryDto categoryDto = mapper.convertValue(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public CategoryDto updateCategory(ObjectId id, CategoryRequestDto request) {
        Category category = categoryRepository.findById(id);
        if (category == null) {
            throw new WebApplicationException("Category Not Found", 404);
        }

        category.setName(request.name());
        category.setUpdatedAt(new Date());
        categoryRepository.update(category);
        return new CategoryDto(category.id, category.getName(), category.getIsActive(), category.getCreatedAt(), category.getUpdatedAt());
    }

    @Override
    public void updateStatusCategory(ObjectId id) {
        Category category = categoryRepository.findById(id);
        if (category == null) {
            throw new WebApplicationException("Category Not Found", 404);
        }

        category.setUpdatedAt(new Date());
        category.setIsActive(!category.getIsActive());
        categoryRepository.update(category);
    }
}
