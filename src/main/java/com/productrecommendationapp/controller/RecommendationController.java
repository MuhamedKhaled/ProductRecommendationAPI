package com.productrecommendationapp.controller;


import com.productrecommendationapp.model.Product;
import com.productrecommendationapp.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/{userId}")
    public List<Product> recommendProducts(@PathVariable Long userId) {
        return recommendationService.recommendProducts(userId);
    }
}
