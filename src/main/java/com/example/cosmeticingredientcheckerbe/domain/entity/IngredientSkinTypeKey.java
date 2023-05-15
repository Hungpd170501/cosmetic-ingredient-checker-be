package com.example.cosmeticingredientcheckerbe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IngredientSkinTypeKey implements Serializable {
    @Column(name = "ingredient_id")
    Long ingredientId;

    @Column(name = "skin_type_id")
    Long skinTypeId;
}
