package com.unibuc.project.barbershop.dto;

import com.unibuc.project.barbershop.model.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@ApiModel(value = "Hairstyle Product request", description = "Required details needed to create a new product")
public class HairstyleProductRequest {
    @NotBlank
    @ApiModelProperty(value = "name", required = true, notes = "The name of hairstyling product", example = "Fade haircut", position = 1)
    private String name;

    @NotNull
    @Min(0)
    @ApiModelProperty(value = "purchase_price", required = true, notes = "The purchase price", example = "40", position = 2)
    private double purchasePrice;

    public HairstyleProductRequest(String name, double purchasePrice) {
        this.name = name;
        this.purchasePrice = purchasePrice;
    }

    public HairstyleProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}
