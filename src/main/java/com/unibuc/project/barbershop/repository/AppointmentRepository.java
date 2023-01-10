package com.unibuc.project.barbershop.repository;

import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.model.PaymentType;
import com.unibuc.project.barbershop.model.Workday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Optional<Appointment> findByDateAndStartTime(LocalDate date, String StartTime);

    List<Appointment> findAllByPaymentType(PaymentType type);



}
