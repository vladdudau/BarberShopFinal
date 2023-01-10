package com.unibuc.project.barbershop.dto;

import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Gender;
import com.unibuc.project.barbershop.model.Workday;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.unibuc.project.barbershop.model.Pattern.HH_MM_timer;
import static com.unibuc.project.barbershop.model.Pattern.RO_phone_number;

@ApiModel(value = "Work Schedule request", description = "Required details needed to create a new schedule")
public class WorkScheduleRequest {


    @ApiModelProperty(value = "barber", required = false, notes = "The Barber who uses this schedule", position = 1)
    private Barber barber;

    @NotNull
    @ApiModelProperty(value = "workdays", required = true, notes = "The workday where schedule is available", example = "MONDAY", position = 2)
    private Workday workday;


    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "startTime", required = true, notes = "Schedule start time", example="16:00", position = 3)
    private String startTime;

    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "endTime", required = true, notes = "Schedule end time", example="21:00", position = 4)
    private String endTime;

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public Workday getWorkday() {
        return workday;
    }

    public void setWorkday(Workday workday) {
        this.workday = workday;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }


    public WorkScheduleRequest(Barber barber, Workday workday, String startTime, String endTime) {
        this.barber = barber;
        this.workday = workday;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
