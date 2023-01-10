package com.unibuc.project.barbershop.mapper;

import com.unibuc.project.barbershop.dto.AppointmentRequest;
import com.unibuc.project.barbershop.model.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    public Appointment AppointRequestToAppointment(AppointmentRequest appointmentRequest) {
        return new Appointment(appointmentRequest.getCustomer(), appointmentRequest.getBarber(), false, appointmentRequest.getPaymentType(),
                appointmentRequest.getDate(), appointmentRequest.getStartTime(), appointmentRequest.getEndTime(), appointmentRequest.getProducts());
        }
}
