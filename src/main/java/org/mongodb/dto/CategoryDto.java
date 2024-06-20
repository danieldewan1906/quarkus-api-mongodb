package org.mongodb.dto;

import org.bson.types.ObjectId;

import java.util.Date;

public record CategoryDto(
        ObjectId id,
        String name,
        Boolean isActive,
        Date createdAt,
        Date updatedAt
) {
}
