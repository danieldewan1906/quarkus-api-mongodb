package org.mongodb.dto;

import io.smallrye.common.constraint.NotNull;

public record CategoryRequestDto(
        @NotNull
        String name
) {
}
