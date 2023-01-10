package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.BarberNotFoundException;
import com.unibuc.project.barbershop.exception.DuplicateCustomerException;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        Optional<Customer> existingCustomerSameName = customerRepository.findByName(customer.getName());

        existingCustomerSameName.ifPresent(e -> {
            throw new DuplicateCustomerException();
        });
        return customerRepository.save(customer);
    }


}
