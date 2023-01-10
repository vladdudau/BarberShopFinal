package com.unibuc.project.barbershop.repository;

import com.unibuc.project.barbershop.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findAllByWorkdaysIn(List<Workday> workdays);

    Optional<WorkSchedule> findByBarberAndStartTimeAndWorkdaysIn(Barber barber, String startTime, List<Workday> workdays);
}
