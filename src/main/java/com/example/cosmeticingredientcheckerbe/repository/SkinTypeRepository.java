package com.example.cosmeticingredientcheckerbe.repository;

import com.example.cosmeticingredientcheckerbe.domain.entity.SkinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinTypeRepository extends JpaRepository<SkinType, Long> {
}
