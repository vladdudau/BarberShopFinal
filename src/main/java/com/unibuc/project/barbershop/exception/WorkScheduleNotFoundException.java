package com.unibuc.project.barbershop.exception;

public class WorkScheduleNotFoundException extends RuntimeException {
    public WorkScheduleNotFoundException(long id) {
        super("Schedule with id " + id + " doesn't exist ");
    }
}
