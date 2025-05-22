package com.dealsapp.deals_coupons_offers_service.service;

import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponDTO;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponRequest;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponUpdate;

import java.util.List;

public interface DealCouponService {
    DealCouponDTO createDeal(DealCouponRequest request);

    DealCouponDTO getById(Long Id);

    List<DealCouponDTO> getAllDeals();

    DealCouponDTO updateDeal(Long Id, DealCouponUpdate update);


    String deleteDeal(Long id);

    List<DealCouponDTO> getDealsByType(String type); // DEAL / COUPON / OFFER

    List<DealCouponDTO> getDealsByStore(String store);

    List<DealCouponDTO> getDealsByCategory(String category);

    List<DealCouponDTO> searchByKeyword(String keyword);
}
