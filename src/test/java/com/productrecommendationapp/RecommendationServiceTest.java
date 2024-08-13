package com.productrecommendationapp;

import com.productrecommendationapp.model.Product;
import com.productrecommendationapp.model.User;
import com.productrecommendationapp.repository.ProductRepository;
import com.productrecommendationapp.repository.UserRepository;
import com.productrecommendationapp.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private RecommendationService recommendationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRecommendProducts() {
        // Setup mock user with preferences
        User user = new User();
        user.setId(1L);
        user.setName("Ahmed");
        user.setEmail("ahmed@example.com");
//        user.setPreferences(Map.of(
//                "subCategories", "Millefeuille & Profiterole,Cables & Plugs",
//                "brands", "Breadfast"
//        ));

        // Setup mock products
        Product product1 = new Product(1L, "Breadfast Classic Millefeuille Cup", "Bakeries & Pastries", "Millefeuille & Profiterole", "Breadfast");
        Product product2 = new Product(3L, "iLock 3 Outlet Wall Plug (3500W)", "Home", "Cables & Plugs", "iLock");
        Product product3 = new Product(4L, "Breadfast Mini Croissants", "Bakeries & Pastries", "Croissants", "Breadfast");

        // Mock the repository methods
        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
        when(productRepository.findRecommendedProducts(anyList(), anyList())).thenReturn(Arrays.asList(product1, product2));

        // Execute the service method
        List<Product> recommendedProducts = recommendationService.recommendProducts(1L);

        // Verify the interaction with the repositories and the result
        verify(userRepository, times(1)).findById(1L);
        verify(productRepository, times(1)).findRecommendedProducts(anyList(), anyList());

        assertEquals(2, recommendedProducts.size());
        assertEquals(product1.getId(), recommendedProducts.get(0).getId());
        assertEquals(product2.getId(), recommendedProducts.get(1).getId());
    }
}
