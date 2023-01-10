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

    @NotNull
    @ApiModelProperty(value = "barber", required = true, notes = "The Barber who uses this schedule", example = "Id lookup or all details of barber", position = 1)
    private Barber barber;

    @NotNull
    @ApiModelProperty(value = "workdays", required = true, notes = "The workdays schedule is valid", example = "{MONDAY,TUESDAY}", position = 2)
    private List<Workday> workdays;

    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "startTime", required = true, notes = "Schedule start date", example="16:00", position = 3)
    private String startTime;

    @NotBlank
    @Pattern(regexp = HH_MM_timer)
    @ApiModelProperty(value = "startTime", required = true, notes = "Schedule start date", example="21:00", position = 4)
    private String endTime;

    public Barber getBarber() {
        return barber;
    }

    public void setBarber(Barber barber) {
        this.barber = barber;
    }

    public List<Workday> getWorkdays() {
        return workdays;
    }

    public void setWorkdays(List<Workday> workdays) {
        this.workdays = workdays;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
