package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.DuplicateAppointmentException;
import com.unibuc.project.barbershop.exception.DuplicateBarberException;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.repository.AppointmentRepository;
import com.unibuc.project.barbershop.repository.BarberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BarberServiceTest {

    @InjectMocks
    private BarberService barberService;


    @Mock
    private BarberRepository barberRepository;

    @Test
    void whenBarberAlreadyExists_create_throwsDuplicateAppointmentException() {
        // Arrange
        Barber barber = new Barber();
        barber.setName("Anghel Malone");
        when(barberRepository.findByName (barber.getName()))
                .thenReturn(Optional.of(barber));

        // Act
        DuplicateBarberException exception = assertThrows(DuplicateBarberException.class,
                () -> barberService.create(barber));

        // Assert
        assertEquals("A barber with same name exists already.", exception.getMessage());
        verify(barberRepository, times(0)).save(barber);

    }

    @Test
    void whenAppointmentDoesntExist_create_savesTheAppointment() {
        // Arrange
        Barber barber = new Barber();
        barber.setName("Anghel Malone");
        when(barberRepository.findByName (barber.getName()))
                .thenReturn(Optional.empty());

        Barber savedBarber = new Barber();
        savedBarber.setName("Anghel Malone");
        when(barberRepository.save(barber)).thenReturn(savedBarber);

        // Act
        Barber result = barberService.create(barber);

        // Assert
        assertNotNull(result);
        assertEquals(savedBarber.getId(), result.getId());
        assertEquals(savedBarber.getName(), result.getName());
        verify(barberRepository).findByName(barber.getName());
        verify(barberRepository).save(barber);
    }

    @Test
    void whenBarberExists_findById_returnsTheBarber() {
        // Arrange
        Barber barber = new Barber();
        barber.setId(1);
        when(barberRepository.findById(1L)).thenReturn(Optional.of(barber));

        // Act
        Optional<Barber> result = barberService.findById(1);

        // Assert
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(barber.getId(), result.get().getId());
    }

    @Test
    void whenBarberDoesntExists_findById_returnsEmptyOptional() {
        // Arrange
        when(barberRepository.findById(1L)).thenReturn(Optional.empty());
        // Act
        Optional<Barber> result = barberService.findById(1);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

}