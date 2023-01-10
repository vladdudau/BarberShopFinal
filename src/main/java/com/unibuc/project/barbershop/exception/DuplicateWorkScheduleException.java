package com.unibuc.project.barbershop.exception;

public class DuplicateWorkScheduleException extends RuntimeException {
    public DuplicateWorkScheduleException() {
        super("A schedule already exists in the same interval for selected barber.");
    }
}
