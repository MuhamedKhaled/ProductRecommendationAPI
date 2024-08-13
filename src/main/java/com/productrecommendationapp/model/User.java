package com.productrecommendationapp.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;


// TODO: Use lombok instead of setters and getters


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ElementCollection
    @CollectionTable(name = "USER_PREFERENCES", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "preference_type")
    @Column(name = "preferences")
    private Map<String, String> preferences;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PurchaseHistory> purchaseHistory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<String, String> preferences) {
        this.preferences = preferences;
    }

    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
}
