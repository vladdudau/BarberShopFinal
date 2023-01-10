package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.AppointmentNotFoundException;
import com.unibuc.project.barbershop.exception.DuplicateAppointmentException;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.PaymentType;
import com.unibuc.project.barbershop.repository.AppointmentRepository;
import com.unibuc.project.barbershop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment create(Appointment appointment) {
        Optional<Appointment> existingAppointmentSameSeat =
                appointmentRepository.findByDateAndStartTime(appointment.getDate(), appointment.getStartTime());

        existingAppointmentSameSeat.ifPresent(e -> {
            throw new DuplicateAppointmentException();
        });
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Long id) {
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        if(appointmentOptional.isPresent()) {
            return appointmentOptional.get();
        } else {
            throw new AppointmentNotFoundException(id);
        }
    }

    public List<Appointment> getAllByPaymentType(PaymentType type) {
        return  appointmentRepository.findAllByPaymentType(type);
    }


}
