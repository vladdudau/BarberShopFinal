package com.unibuc.project.barbershop.service;

import com.unibuc.project.barbershop.exception.DuplicateAppointmentException;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

    @InjectMocks
    private AppointmentService appointmentService;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Test
    void whenAppointmentAlreadyExists_create_throwsDuplicateAppointmentException() {
        // Arrange
        Appointment appointment = new Appointment();

        appointment.setDate(LocalDate.of(2023,02,10));
        appointment.setStartTime("16:00");
        appointment.setEndTime("20:00");

        when(appointmentRepository.findByDateAndStartTime(appointment.getDate(), appointment.getStartTime()))
                .thenReturn(Optional.of(appointment));

        // Act
        DuplicateAppointmentException exception = assertThrows(DuplicateAppointmentException.class,
                () -> appointmentService.create(appointment));

        // Assert
        assertEquals("An appointment with the same date and start time already exists.", exception.getMessage());
        verify(appointmentRepository, times(0)).save(appointment);

    }

    @Test
    void whenAppointmentDoesntExist_create_savesTheAppointment() {
        // Arrange
        Appointment appointment = new Appointment();
        LocalDate date = LocalDate.of(2023,4,1);
        appointment.setDate(date);
        appointment.setStartTime("16:00");
        appointment.setEndTime("20:00");
        when(appointmentRepository.findByDateAndStartTime(appointment.getDate(), appointment.getStartTime()))
                .thenReturn(Optional.empty());
        Appointment savedAppointment = new Appointment();
        savedAppointment.setDate(date);
        savedAppointment.setStartTime("16:00");
        savedAppointment.setEndTime("20:00");
        when(appointmentRepository.save(appointment)).thenReturn(savedAppointment);

        // Act
        Appointment result = appointmentService.create(appointment);

        // Assert
        assertNotNull(result);
        assertEquals(savedAppointment.getId(), result.getId());
        assertEquals(savedAppointment.getDate(), result.getDate());
        assertEquals(appointment.getDate(), result.getDate());
        verify(appointmentRepository).findByDateAndStartTime(appointment.getDate(), appointment.getStartTime());
        verify(appointmentRepository).save(appointment);
    }

    @Test
    void whenAppointmentExists_findById_returnsTheAppointment() {
        // Arrange
        Appointment appointment = new Appointment();
        appointment.setId(1);
        when(appointmentRepository.findById(1L)).thenReturn(Optional.of(appointment));

        // Act
        Optional<Appointment> result = appointmentService.findById(1);

        // Assert
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(appointment.getId(), result.get().getId());
    }

    @Test
    void whenAppointmentDoesntExists_findById_returnsEmptyOptional() {
        // Arrange
        when(appointmentRepository.findById(1L)).thenReturn(Optional.empty());
        // Act
        Optional<Appointment> result = appointmentService.findById(1);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

}