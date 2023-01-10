package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.BarberNotFoundException;
import com.unibuc.project.barbershop.exception.DuplicateBarberException;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.repository.BarberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BarberService {
    private final BarberRepository BarberRepository;

    public BarberService(BarberRepository barberRepository) {
        BarberRepository = barberRepository;
    }

    public Barber create(Barber barber) {
        Optional<Barber> existingBarberSameName =
                BarberRepository.findByName(barber.getName());
        existingBarberSameName.ifPresent(e -> {
            throw new DuplicateBarberException();
        });
        return BarberRepository.save(barber);
    }

    public Barber getBarber(Long id) {
        Optional<Barber> barberOptional = BarberRepository.findById(id);
        if(barberOptional.isPresent()) {
            return barberOptional.get();
        } else {
            throw new BarberNotFoundException(id);
        }
    }

    public Optional<Barber> findById(long id) {
        return BarberRepository.findById(id);
    }


}
