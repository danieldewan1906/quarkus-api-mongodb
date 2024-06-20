package org.mongodb.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.mongodb.dto.CategoryDto;
import org.mongodb.dto.CategoryRequestDto;
import org.mongodb.service.CategoryService;

import java.util.List;

@Path("/api/category")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @Inject
    private CategoryService categoryService;

    @POST
    public CategoryDto createCategory(@RequestBody CategoryRequestDto request) {
        CategoryDto categoryDto = categoryService.createCategory(request);
        return categoryDto;
    }

    @GET
    public List<CategoryDto> listCategory() {
        List<CategoryDto> categoryDtos = categoryService.getListCategory();
        return categoryDtos;
    }

    @GET
    @Path("{id}")
    public CategoryDto getCategoryById(@PathParam("id") ObjectId id) {
        CategoryDto categoryDto = categoryService.getCategoryById(id);
        return categoryDto;
    }

    @PUT
    @Path("{id}")
    public CategoryDto updateCategory(@PathParam("id") ObjectId id, @RequestBody CategoryRequestDto request) {
        CategoryDto categoryDto = categoryService.updateCategory(id, request);
        return categoryDto;
    }

    @PUT
    @Path("/status/{id}")
    public Boolean updateStatusCategory(@PathParam("id") ObjectId id) {
        categoryService.updateStatusCategory(id);
        return true;
    }
}
