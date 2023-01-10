package com.unibuc.project.barbershop.repository;

import com.unibuc.project.barbershop.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
    List<WorkSchedule> findAllByWorkday(Workday workday);

    Optional<WorkSchedule> findByBarberAndStartTimeAndWorkday(Barber barber, String startTime, Workday workday);
}
