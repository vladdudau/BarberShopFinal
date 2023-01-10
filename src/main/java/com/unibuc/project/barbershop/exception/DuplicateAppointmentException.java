package com.unibuc.project.barbershop.exception;

public class DuplicateAppointmentException extends RuntimeException {
    public DuplicateAppointmentException() {
        super("An appointment with the same date and start time already exists.");
    }
}
