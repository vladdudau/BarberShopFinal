package com.unibuc.project.barbershop.mapper;

import com.unibuc.project.barbershop.dto.AppointmentRequest;
import com.unibuc.project.barbershop.dto.CustomerRequest;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.Gender;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer CustomerRequestToCustomer(CustomerRequest customerRequest) {
        return new Customer(customerRequest.getName(), customerRequest.getGender(), customerRequest.getPhoneNumber());
    }
}
