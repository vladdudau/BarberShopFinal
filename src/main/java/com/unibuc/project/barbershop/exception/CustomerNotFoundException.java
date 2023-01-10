package com.unibuc.project.barbershop.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super("Customer with id " + id + " doesn't exist ");
    }
}
