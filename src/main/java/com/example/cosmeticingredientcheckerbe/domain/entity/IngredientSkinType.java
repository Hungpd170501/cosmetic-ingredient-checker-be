package com.example.cosmeticingredientcheckerbe.domain.entity;

import com.example.cosmeticingredientcheckerbe.constants.EffectLevel;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class IngredientSkinType {
    @EmbeddedId
    IngredientSkinTypeKey id;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    @ManyToOne
    @MapsId("skinTypeId")
    @JoinColumn(name = "skin_type_id")
    SkinType skinType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EffectLevel effectLevel;
}
