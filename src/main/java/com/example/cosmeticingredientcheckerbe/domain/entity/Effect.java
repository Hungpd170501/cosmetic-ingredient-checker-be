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
public class Effect extends BaseEntity {
    @NotBlank(message = "effect name is required")
    @Column(nullable = false,
            unique = true
    )
    private String name;
    @NotBlank(message = "effect description is required")
    @Column(nullable = false,
            unique = true
    )
    private String description;
    @ManyToMany(mappedBy = "effects")
    @Builder.Default
    private Set<Ingredient> ingredients = new HashSet<>();
}
