package com.dealsapp.deals_coupons_offers_service.service;


import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponDTO;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponRequest;
import com.dealsapp.deals_coupons_offers_service.DTO.DealCouponUpdate;
import com.dealsapp.deals_coupons_offers_service.model.DealEntity;
import com.dealsapp.deals_coupons_offers_service.repository.DealCouponRepository;
import com.dealsapp.deals_coupons_offers_service.service.DealCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DealCouponServiceImpl implements DealCouponService {

    private final DealCouponRepository repository;

    public DealCouponServiceImpl(DealCouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public DealCouponDTO createDeal(DealCouponRequest request) {
        DealEntity entity = new DealEntity();
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setType(request.getType());
        entity.setStore(request.getStore());
        entity.setCategory(request.getCategory());
        entity.setExpirationDate(request.getExpirationDate());
        entity.setFeatured(request.isFeatured());

        DealEntity saved = repository.save(entity);
        return mapToDTO(saved);
    }

    @Override
    public DealCouponDTO getById(Long id) {
        DealEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deal/Coupon/Offer not found with ID: " + id));
        return mapToDTO(entity);
    }

    @Override
    public List<DealCouponDTO> getAllDeals() {
        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public DealCouponDTO updateDeal(Long id, DealCouponUpdate update) {
        DealEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deal/Coupon/Offer not found with ID: " + id));

        entity.setTitle(update.getTitle());
        entity.setDescription(update.getDescription());
        entity.setType(update.getType());
        entity.setStore(update.getStore());
        entity.setCategory(update.getCategory());
        entity.setExpirationDate(update.getExpirationDate());
        entity.setFeatured(update.isFeatured());

        DealEntity updated = repository.save(entity);
        return mapToDTO(updated);

    }

    @Override
    public String deleteDeal(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Deal/Coupon/Offer not found with ID: " + id);
        }
        repository.deleteById(id);
        return "Deleted successfully!";
    }

    @Override
    public List<DealCouponDTO> getDealsByType(String type) {
        return repository.findByType(type).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DealCouponDTO> getDealsByStore(String store) {
        return repository.findByStore(store).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DealCouponDTO> getDealsByCategory(String category) {
        return repository.findByCategory(category).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<DealCouponDTO> searchByKeyword(String keyword) {
        return repository.findByTitleContaining(keyword).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private DealCouponDTO mapToDTO(DealEntity entity) {
        DealCouponDTO dto = new DealCouponDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setStore(entity.getStore());
        dto.setCategory(entity.getCategory());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setFeatured(entity.isFeatured());
        return dto;
    }
}


