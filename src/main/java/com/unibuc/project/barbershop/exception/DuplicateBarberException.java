package com.unibuc.project.barbershop.exception;

public class DuplicateBarberException extends RuntimeException {
    public DuplicateBarberException() {
        super("A barber with same name exists already.");
    }
}
