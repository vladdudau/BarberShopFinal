package com.unibuc.project.barbershop.controller;

import com.unibuc.project.barbershop.dto.BarberRequest;
import com.unibuc.project.barbershop.dto.HairstyleProductRequest;
import com.unibuc.project.barbershop.mapper.BarberMapper;
import com.unibuc.project.barbershop.mapper.HairstyleProductMapper;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.HairstyleProduct;
import com.unibuc.project.barbershop.service.BarberService;
import com.unibuc.project.barbershop.service.HairstyleProductService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/products")
@Api(value="/products", tags = "Hairstyle Products")
public class HairstyleProductController {

    private HairstyleProductService hairstyleProductService;

    private HairstyleProductMapper hairstyleProductMapper;

    public HairstyleProductController(HairstyleProductService hairstyleProductService, HairstyleProductMapper hairstyleProductMapper) {
        this.hairstyleProductService = hairstyleProductService;
        this.hairstyleProductMapper = hairstyleProductMapper;
    }

    @PostMapping
    @ApiOperation(value="Create a hairstyle Product",
            notes="Creates a hairstyle Product based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The hairstyle Product was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<HairstyleProduct> create(
            @RequestBody
            @ApiParam(name = "product", value = "Hairstyle Product details", required = true)
            HairstyleProductRequest hairstyleProductRequest)
    {
        HairstyleProduct savedHairstyleProduct = hairstyleProductService.create(hairstyleProductMapper.HairstyleProductRequestToHairstyleProduct(hairstyleProductRequest));
        return ResponseEntity
                .created(URI.create("/barbers/"+savedHairstyleProduct.getId()))
                .body(savedHairstyleProduct);
    }
}

