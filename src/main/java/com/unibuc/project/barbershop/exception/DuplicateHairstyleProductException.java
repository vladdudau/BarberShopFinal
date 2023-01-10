package com.unibuc.project.barbershop.exception;

public class DuplicateHairstyleProductException extends RuntimeException {
    public DuplicateHairstyleProductException() {
        super("An hairstyling product with same name exists already.");
    }
}
