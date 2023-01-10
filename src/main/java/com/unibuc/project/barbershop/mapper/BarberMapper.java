package com.unibuc.project.barbershop.mapper;

import com.unibuc.project.barbershop.dto.BarberRequest;
import com.unibuc.project.barbershop.dto.CustomerRequest;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.Gender;
import com.unibuc.project.barbershop.model.WorkSchedule;
import org.springframework.stereotype.Component;

@Component
public class BarberMapper {
    public Barber BarberMapperRequestToBarber(BarberRequest barberRequest) {
        return new Barber(barberRequest.getName() , barberRequest.getWorkSchedules(), barberRequest.getGender(), barberRequest.getPhoneNumber(), barberRequest.getSeatNumber());
    }
}
