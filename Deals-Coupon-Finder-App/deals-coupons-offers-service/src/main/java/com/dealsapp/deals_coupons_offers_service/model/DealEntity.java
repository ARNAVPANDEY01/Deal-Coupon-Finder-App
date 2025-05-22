package com.dealsapp.deals_coupons_offers_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "delas_coupon_offer")
public class DealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;
    private String description;

    @Column(name = "discountPercent")
    private double discountPercent;

    private String type; // "DEAL", "COUPON", or "OFFER"

    private String category;
    private String store;

    @Column(name = "is_active")
    private boolean isActive;

    private boolean featured;

    private String expirationDate;

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    // No-arg constructor
    public DealEntity() {
    }

    // All-arg constructor (without builder)
    public DealEntity(Long id, String title, String description, double discountPercent,
                                 String type, String category, String store, boolean isActive, boolean featured, String expirationDate) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.discountPercent = discountPercent;
        this.type = type;
        this.category = category;
        this.store = store;
        this.isActive = isActive;
        this.featured = featured;
        this.expirationDate = expirationDate;
    }

    // Getters and Setters 👇 (can be generated in IDE)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
