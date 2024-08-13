package com.productrecommendationapp.repository;

import com.productrecommendationapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

     // Not used
    @Query("SELECT p FROM Product p WHERE (:subCategories IS NULL OR p.subCategory IN :subCategories) " +
            "OR (:brands IS NULL OR p.brand IN :brands) ORDER BY " +
            "CASE WHEN p.subCategory IN :subCategories THEN 1 ELSE 2 END, " +
            "CASE WHEN p.brand IN :brands THEN 1 ELSE 2 END")
    List<Product> findRecommendedProducts(
            @Param("subCategories") List<String> subCategories,
            @Param("brands") List<String> brands
    );
}