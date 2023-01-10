package com.unibuc.project.barbershop.exception;

public class DuplicateCustomerException extends RuntimeException {
    public DuplicateCustomerException() {
        super("A customer with same name exists already.");
    }
}
