package com.example.cosmeticingredientcheckerbe.domain.entity;

import jakarta.persistence.*;
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
public class Ingredient extends BaseEntity {
    @NotBlank(message = "ingredient name is required")
    @Column(nullable = false,
            unique = true
    )
    private String name;
    @NotBlank(message = "ingredient description is required")
    @Column(nullable = false,
            unique = true
    )
    private String description;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "ingredient_effect",
            joinColumns = @JoinColumn(
                    name = "ingredient_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_effect_ingredient"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "effect_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_effect_effect"
                    )
            )
    )
    @Builder.Default
    private Set<Effect> effects = new HashSet<>();

    @OneToMany(mappedBy = "ingredient")
    @Builder.Default
    private Set<IngredientSkinType> ingredientSkinTypes = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "ingredient_category",
            joinColumns = @JoinColumn(
                    name = "ingredient_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_category_ingredient"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "category_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_category_category"
                    )
            )
    )
    @Builder.Default
    private Set<Category> categories = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "ingredient_cosmetic",
            joinColumns = @JoinColumn(
                    name = "ingredient_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_cosmetic_ingredient"
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cosmetic_id",
                    nullable = false,
                    foreignKey = @ForeignKey(
                            name = "fk_ingredient_cosmetic_cosmetic"
                    )
            )
    )
    @Builder.Default
    private Set<Cosmetic> cosmetics = new HashSet<>();
}
