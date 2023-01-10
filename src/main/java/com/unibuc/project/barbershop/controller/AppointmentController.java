package com.unibuc.project.barbershop.controller;

import com.unibuc.project.barbershop.dto.AppointmentRequest;
import com.unibuc.project.barbershop.mapper.AppointmentMapper;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.PaymentType;
import com.unibuc.project.barbershop.service.AppointmentService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/appointments")
@Api(value="/appointments", tags = "Appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    private AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @PostMapping
    @ApiOperation(value="Create an appointment",
            notes="Creates an appointment based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The appointment was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<Appointment> create(
            @RequestBody
            @ApiParam(name = "appointment", value = "Appointment details", required = true)
            AppointmentRequest appointmentRequest)
    {
        Appointment savedAppointment = appointmentService.create(appointmentMapper.AppointRequestToAppointment(appointmentRequest));
        return ResponseEntity
                .created(URI.create("/appointments/"+savedAppointment.getId()))
                .body(savedAppointment);
    }


    @GetMapping("/{id}")
    @ApiOperation(value="Get an appointment",
            notes="Get an appointment based on the id")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "The appointment was successfully received based on the id"),
            @ApiResponse(code = 400, message = "Validation error on the received request")}
    )
    public Appointment getAppointment(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }

    @GetMapping
    @ApiOperation(value="Get all appointments",
            notes="Get all appointment based on the payment type")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "The appointments successfully received based on the payment type"),
            @ApiResponse(code = 400, message = "Validation error on the received request")}
    )
    public List<Appointment> getAllByPaymentType(@RequestParam PaymentType type) {
        return appointmentService.getAllByPaymentType(type);
    }




}

