package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.DuplicateHairstyleProductException;
import com.unibuc.project.barbershop.model.WorkSchedule;
import com.unibuc.project.barbershop.repository.WorkScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkScheduleService {
    private final WorkScheduleRepository workScheduleRepository;

    public WorkScheduleService(WorkScheduleRepository workScheduleRepository) {
        this.workScheduleRepository = workScheduleRepository;
    }

    public WorkSchedule create(WorkSchedule workSchedule) {
        Optional<WorkSchedule> existingWorkSchedule =
                workScheduleRepository.findByBarberAndStartTimeAndWorkday(workSchedule.getBarber(), workSchedule.getStartTime(), workSchedule.getWorkday());

        existingWorkSchedule.ifPresent(e -> {
            throw new DuplicateHairstyleProductException();
        });
        return workScheduleRepository.save(workSchedule);
    }

}
