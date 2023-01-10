package com.unibuc.project.barbershop.mapper;

import com.unibuc.project.barbershop.dto.CustomerRequest;
import com.unibuc.project.barbershop.dto.HairstyleProductRequest;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.HairstyleProduct;
import org.springframework.stereotype.Component;

@Component
public class HairstyleProductMapper {
    public HairstyleProduct HairstyleProductRequestToHairstyleProduct(HairstyleProductRequest hairstyleProductRequest) {
        return new HairstyleProduct(hairstyleProductRequest.getName(), hairstyleProductRequest.getPurchasePrice());
    }
}
