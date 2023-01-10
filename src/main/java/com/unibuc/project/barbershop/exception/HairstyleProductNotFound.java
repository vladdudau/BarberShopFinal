package com.unibuc.project.barbershop.exception;

public class HairstyleProductNotFound extends RuntimeException {
    public HairstyleProductNotFound(long id) {
        super("Product with id " + id + " doesn't exist ");
    }
}
