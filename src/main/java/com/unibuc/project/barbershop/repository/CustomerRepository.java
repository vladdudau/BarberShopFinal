package com.unibuc.project.barbershop.repository;

import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.model.Workday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByName(String name);
}
