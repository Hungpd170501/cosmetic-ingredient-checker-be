package com.example.cosmeticingredientcheckerbe.repository;

import com.example.cosmeticingredientcheckerbe.domain.entity.Cosmetic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CosmeticRepository extends JpaRepository<Cosmetic, Long> {
    Page<Cosmetic> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query(value = "SELECT * FROM public.cosmetic WHERE unaccent(name) like %:name%",
            nativeQuery = true)
//    CREATE EXTENSION unaccent; in postgresql
    Page<Cosmetic> findAllByNameContainingIgnoreCaseEscapeAccent(@Param("name") String name, Pageable pageable);
}
