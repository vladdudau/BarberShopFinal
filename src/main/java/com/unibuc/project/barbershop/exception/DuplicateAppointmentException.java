package com.unibuc.project.barbershop.exception;

public class DuplicateAppointmentException extends RuntimeException {
    public DuplicateAppointmentException() {
        super("An appointment with same barber at same date and time exists already.");
    }
}
