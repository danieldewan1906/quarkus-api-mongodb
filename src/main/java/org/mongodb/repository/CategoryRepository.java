package org.mongodb.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.mongodb.entity.Category;

@ApplicationScoped
public class CategoryRepository implements PanacheMongoRepository<Category> {

    public void saveCategory(Category category) {
        persist(category);
    }
}
