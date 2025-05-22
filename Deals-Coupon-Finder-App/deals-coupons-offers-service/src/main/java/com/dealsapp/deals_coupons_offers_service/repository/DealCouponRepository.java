package com.dealsapp.deals_coupons_offers_service.repository;

import com.dealsapp.deals_coupons_offers_service.model.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealCouponRepository extends JpaRepository<DealEntity,Long>{
    List<DealEntity> findByType(String type);       // DEAL / COUPON / OFFER

    List<DealEntity> findByStore(String store);     // Store-wise filtering

    List<DealEntity> findByCategory(String category); // Category-wise filtering

    List<DealEntity> findByTitleContaining(String title); // For
}
