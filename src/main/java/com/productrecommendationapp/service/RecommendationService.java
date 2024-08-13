package com.productrecommendationapp.service;

import com.productrecommendationapp.model.Product;
import com.productrecommendationapp.model.User;
import com.productrecommendationapp.repository.ProductRepository;
import com.productrecommendationapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Product> recommendProducts(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return Collections.emptyList();
        }

        List<String> subCategoryPreferences =
                Arrays.asList(user.getPreferences().getOrDefault("subCategories", "").split(","));
        List<String> brandPreferences =
                Arrays.asList(user.getPreferences().getOrDefault("brands", "").split(","));

        List<Product> allProducts = productRepository.findAll();

        return allProducts.stream()
                .filter(product -> subCategoryPreferences.contains(product.getSubCategory()) || brandPreferences.contains(product.getBrand()))
                .sorted(Comparator.comparing((Product p) -> subCategoryPreferences.contains(p.getSubCategory()) && brandPreferences.contains(p.getBrand()))
                        .reversed()
                        .thenComparing(p -> subCategoryPreferences.contains(p.getSubCategory()))
                        .reversed()
                        .thenComparing(p -> brandPreferences.contains(p.getBrand()))
                        .reversed())
                .collect(Collectors.toList());

    }

}
