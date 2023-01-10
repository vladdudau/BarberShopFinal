package com.unibuc.project.barbershop.dto;

import com.unibuc.project.barbershop.model.Gender;
import com.unibuc.project.barbershop.model.WorkSchedule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@ApiModel(value = "Barber request", description = "Required details needed to create a new barber")
public class BarberRequest {
    @NotBlank
    @Max(50)
    @ApiModelProperty(value = "name", required = true, notes = "The name of barber", example = "Alin Popescu", position = 1)
    private String name;

    @ApiModelProperty(value = "work_schedules", required = true, notes = "Work schedule", example = "Id lookup or all details", position = 2)
    private List<WorkSchedule> workSchedules;

    @NotNull
    @ApiModelProperty(value = "gender", required = true, notes = "The gender of the barber", example = "Male/Female/Unknown", position = 3)
    private Gender gender;

    @NotBlank
    @ApiModelProperty(value = "phone_number", required = true, notes = "The RO phone number of the barber", example = "0723456789", position = 4)
    private String phoneNumber;

    @NotNull
    @Min(0)
    @ApiModelProperty(value = "seat_number", required = true, notes = "The seat number of the barber workplace", example ="1", position = 5)
    private Integer seatNumber;

    public BarberRequest(String name, List<WorkSchedule> workSchedules, Gender gender, String phoneNumber, Integer seatNumber) {
        this.name = name;
        this.workSchedules = workSchedules;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.seatNumber = seatNumber;
    }

    public BarberRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkSchedule> getWorkSchedules() {
        return workSchedules;
    }

    public void setWorkSchedules(List<WorkSchedule> workSchedules) {
        this.workSchedules = workSchedules;
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

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }
}
