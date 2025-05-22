package com.dealsapp.deals_coupons_offers_service.DTO;

public class DealCouponUpdate {
    private String title;
    private String description;
    private String category;
    private String store;
    private String type;
    private boolean featured;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    private String expirationDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public DealCouponUpdate(String title, String description, String category, String store, boolean featured, String type, boolean active, String expirationDate) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.store = store;
        this.featured = featured;
        this.type = type;
        this.active = active;
        this.expirationDate = expirationDate;
    }
}
