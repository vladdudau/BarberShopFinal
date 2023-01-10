package com.unibuc.project.barbershop.mapper;

import com.unibuc.project.barbershop.dto.CustomerRequest;
import com.unibuc.project.barbershop.dto.WorkScheduleRequest;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.WorkSchedule;
import com.unibuc.project.barbershop.model.Workday;
import org.springframework.stereotype.Component;

@Component
public class WorkScheduleMapper {
    public WorkSchedule WorkScheduleRequestToWorkSchedule(WorkScheduleRequest workScheduleRequest) {
        return new WorkSchedule(workScheduleRequest.getBarber() ,workScheduleRequest.getWorkday(), workScheduleRequest.getStartTime(), workScheduleRequest.getEndTime());
    }
}
