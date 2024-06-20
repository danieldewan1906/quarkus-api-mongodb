package org.mongodb.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.smallrye.common.constraint.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@MongoEntity(database = "quarkus-restful-api", collection = "category")
public class Category extends PanacheMongoEntity {

    @NotNull
    private String name;
    @NotNull
    private Boolean isActive;
    @NotNull
    private Date createdAt;
    private Date updatedAt;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
