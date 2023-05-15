package com.example.cosmeticingredientcheckerbe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Category extends BaseEntity {
    @NotBlank(message = "category name is required")
    @Column(nullable = false,
            unique = true
    )
    private String name;
    @NotBlank(message = "category description is required")
    @Column(nullable = false,
            unique = true
    )
    private String description;
    @ManyToMany(mappedBy = "categories")
    @Builder.Default
    private Set<Ingredient> ingredients = new HashSet<>();
}
