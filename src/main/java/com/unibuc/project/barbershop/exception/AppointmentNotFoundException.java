package com.unibuc.project.barbershop.exception;

public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(long id) {
        super("Appointment with id " + id + " doesn't exist ");
    }
}
