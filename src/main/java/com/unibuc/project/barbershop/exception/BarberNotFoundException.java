package com.unibuc.project.barbershop.exception;

public class BarberNotFoundException extends RuntimeException {

    public BarberNotFoundException(long id) {
        super("Barber with id " + id + " doesn't exist ");
    }
}
