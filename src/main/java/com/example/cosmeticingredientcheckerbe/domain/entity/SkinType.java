package com.example.cosmeticingredientcheckerbe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "skin_type")
public class SkinType extends BaseEntity {
    @NotBlank
    @Column(nullable = false,
            unique = true
    )
    private String name;
    @OneToMany(mappedBy = "skinType")
    @Builder.Default
    private Set<IngredientSkinType> ingredientSkinTypes = new HashSet<>();
}
