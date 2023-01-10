package com.unibuc.project.barbershop.dto;

import com.unibuc.project.barbershop.model.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@ApiModel(value = "Customer request", description = "Required details needed to create a new customer")
public class CustomerRequest {
    @NotBlank
    @Max(50)
    @ApiModelProperty(value = "name", required = true, notes = "The name of customer", example = "Andrei Matei", position = 1)
    private String name;

    @NotBlank
    @ApiModelProperty(value = "gender", required = true, notes = "The gender of the customer", example = "Male", position = 2)
    private Gender gender;

    @Pattern(regexp = RO_phone_number)
    @ApiModelProperty(value = "phone_number", required = true, notes = "The RO phone number of the customer", example = "0723456789", position = 3)
    private String phoneNumber;

    public CustomerRequest() {
    }

    public CustomerRequest(String name, Gender gender, String phoneNumber) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
