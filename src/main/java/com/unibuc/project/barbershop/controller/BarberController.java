package com.unibuc.project.barbershop.controller;

import com.unibuc.project.barbershop.dto.AppointmentRequest;
import com.unibuc.project.barbershop.dto.BarberRequest;
import com.unibuc.project.barbershop.mapper.AppointmentMapper;
import com.unibuc.project.barbershop.mapper.BarberMapper;
import com.unibuc.project.barbershop.model.Appointment;
import com.unibuc.project.barbershop.model.Barber;
import com.unibuc.project.barbershop.service.AppointmentService;
import com.unibuc.project.barbershop.service.BarberService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/barbers")
@Api(value="/barbers", tags = "Barbers")
public class BarberController {

    private BarberService barberService;

    private BarberMapper barberMapper;

    public BarberController(BarberService barberService, BarberMapper barberMapper) {
        this.barberService = barberService;
        this.barberMapper = barberMapper;
    }

    @PostMapping
    @ApiOperation(value="Create a barber",
            notes="Creates a barber based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The barber was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<Barber> create(
            @RequestBody
            @ApiParam(name = "barber", value = "Barber details", required = true)
            BarberRequest barberRequest)
    {
        Barber savedBarber = barberService.create(barberMapper.BarberMapperRequestToBarber(barberRequest));
        return ResponseEntity
                .created(URI.create("/barbers/"+savedBarber.getId()))
                .body(savedBarber);
    }
}

