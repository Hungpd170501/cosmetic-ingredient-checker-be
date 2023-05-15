package com.example.cosmeticingredientcheckerbe.repository;

import com.example.cosmeticingredientcheckerbe.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
