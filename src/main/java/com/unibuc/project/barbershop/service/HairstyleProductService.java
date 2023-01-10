package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.DuplicateWorkScheduleException;
import com.unibuc.project.barbershop.model.HairstyleProduct;
import com.unibuc.project.barbershop.repository.HairstyleProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HairstyleProductService {
    private final HairstyleProductRepository hairstyleProductRepository;

    public HairstyleProductService(HairstyleProductRepository hairstyleProductRepository) {
        this.hairstyleProductRepository = hairstyleProductRepository;
    }

    public HairstyleProduct create(HairstyleProduct hairstyleProduct) {
        Optional<HairstyleProduct> existingHairstyleProduct = hairstyleProductRepository.findByName(hairstyleProduct.getName());

        existingHairstyleProduct.ifPresent(e -> {
            throw new DuplicateWorkScheduleException();
        });
        return hairstyleProductRepository.save(hairstyleProduct);
    }

}
