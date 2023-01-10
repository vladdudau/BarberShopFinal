//package com.unibuc.project.barbershop.service;
//
//import com.unibuc.project.barbershop.exception.DuplicateAppointmentException;
//import com.unibuc.project.barbershop.model.Appointment;
//import com.unibuc.project.barbershop.repository.AppointmentRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//
//import static com.unibuc.project.barbershop.model.Pattern.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class AppointmentServiceTest {
//
//    @InjectMocks
//    private AppointmentService appointmentService;
//
//    @Mock
//    private AppointmentRepository appointmentRepository;
//
//    @Test
//    void whenAppointmentAlreadyExists_create_throwsDuplicateAppointmentException() {
//        // Arrange
//        Appointment appointment = new Appointment();
//        LocalDate date = LocalDate.of(2023,4,1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date_format);
//        LocalDate date = formatter.withLocale ("2005-nov-12", formatter);
//        appointment.setDate(formatter.format(formatter.parse (date_format )));
//        appointment.setStartTime("16:00");
//        appointment.setEndTime("20:00");
//
//        when(appointmentRepository.findByDateAndStartTime(appointment.getDate(), appointment.getStartTime()))
//                .thenReturn(Optional.of(appointment));
//
//        // Act
//        DuplicateAppointmentException exception = assertThrows(DuplicateAppointmentException.class,
//                () -> appointmentService.create(appointment));
//
//        // Assert
//        assertEquals("An appointment with the same date and start time already exists.", exception.getMessage());
//        verify(appointmentRepository, times(0)).save(appointment);
//
//    }
//
//    @Test
//    void whenAppointmentDoesntExist_create_savesTheAppointment() {
//        // Arrange
//        Appointment appointment = new Appointment();
//        LocalDate date = LocalDate.of(2023,4,1);
//        appointment.setDate(formatter.format(formatter.parse(date_format)));
//        appointment.setStartTime("16:00");
//        appointment.setEndTime("20:00");
//        when(appointmentRepository.findByDateAndStartTime(appointment.getDate(), appointment.getStartTime()))
//                .thenReturn(Optional.empty());
//        Appointment savedAppointment = new Appointment();
//        LocalDate date = LocalDate.of(2023,4,1);
//        appointment.setDate(formatter.format(formatter.parse(date_format)));
//        appointment.setStartTime("16:00");
//        appointment.setEndTime("20:00");
//        when(appointmentRepository.save(appointment)).thenReturn(savedAppointment);
//
//        // Act
//        Appointment result = appointmentService.create(appointment);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(savedAppointment.getId(), result.getId());
//        assertEquals(savedAppointment.getDate(), result.getDate());
//        assertEquals(appointment.getDate(), result.getDate());
//        verify(appointmentRepository).findByDateAndStartTime(appointment.getDate(), appointment.getStartTime());
//        verify(appointmentRepository).save(appointment);
//    }
//
//
//}