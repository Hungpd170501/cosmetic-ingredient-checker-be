package com.example.cosmeticingredientcheckerbe.repository;

import com.example.cosmeticingredientcheckerbe.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
