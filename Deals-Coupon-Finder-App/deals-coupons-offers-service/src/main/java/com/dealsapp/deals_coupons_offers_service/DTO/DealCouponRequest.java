package com.dealsapp.deals_coupons_offers_service.DTO;

public class DealCouponRequest {
    private String title;
    private String description;
    private String type;
    private String category;
    private String store;
    private boolean featured;
    private String expirationDate;

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
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

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public DealCouponRequest(String title, String description, String type, String category, String store, boolean featured, String expirationDate) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.category = category;
        this.store = store;
        this.featured = featured;
        this.expirationDate = expirationDate;
    }
}
