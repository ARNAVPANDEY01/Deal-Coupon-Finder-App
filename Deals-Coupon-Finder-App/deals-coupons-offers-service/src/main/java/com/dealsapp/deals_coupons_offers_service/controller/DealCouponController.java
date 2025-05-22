package com.dealsapp.deals_coupons_offers_service.controller;

import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponDTO;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponRequest;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponUpdate;
import com.dealsapp.deals_coupons_offers_service.service.DealCouponService;
//import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
@CrossOrigin("*")
//@RequiredArgsConstructor
public class DealCouponController {

    @Autowired
    private final DealCouponService dealCouponService;

    public DealCouponController(DealCouponService dealCouponService) {
        this.dealCouponService = dealCouponService;
    }


    @PostMapping
    public ResponseEntity<DealCouponDTO> createDeal(@RequestBody DealCouponRequest request) {
        return ResponseEntity.ok(dealCouponService.createDeal(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<DealCouponDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dealCouponService.getById(id));
    }


    @GetMapping
    public ResponseEntity<List<DealCouponDTO>> getAllDeals() {
        return ResponseEntity.ok(dealCouponService.getAllDeals());
    }


    @PutMapping("/{id}")
    public ResponseEntity<DealCouponDTO> updateDeal(
            @PathVariable Long id,
            @RequestBody DealCouponUpdate update
    ) {
        return ResponseEntity.ok(dealCouponService.updateDeal(id, update));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeal(@PathVariable Long id) {
        return ResponseEntity.ok(dealCouponService.deleteDeal(id));
    }


    @GetMapping("/type/{type}")
    public ResponseEntity<List<DealCouponDTO>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(dealCouponService.getDealsByType(type));
    }


    @GetMapping("/store/{store}")
    public ResponseEntity<List<DealCouponDTO>> getByStore(@PathVariable String store) {
        return ResponseEntity.ok(dealCouponService.getDealsByStore(store));
    }


    @GetMapping("/category/{category}")
    public ResponseEntity<List<DealCouponDTO>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(dealCouponService.getDealsByCategory(category));
    }

    
    @GetMapping("/search")
    public ResponseEntity<List<DealCouponDTO>> searchByKeyword(@RequestParam String keyword) {
        return ResponseEntity.ok(dealCouponService.searchByKeyword(keyword));
    }
}

