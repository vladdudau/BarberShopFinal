package com.unibuc.project.barbershop.controller;

import com.unibuc.project.barbershop.dto.WorkScheduleRequest;
import com.unibuc.project.barbershop.mapper.WorkScheduleMapper;
import com.unibuc.project.barbershop.model.WorkSchedule;
import com.unibuc.project.barbershop.service.WorkScheduleService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/schedules")
@Api(value="/schedules", tags = "Work Schedules")
public class WorkScheduleController {

    private WorkScheduleService workScheduleService;

    private WorkScheduleMapper workScheduleMapper;

    public WorkScheduleController(WorkScheduleService workScheduleService, WorkScheduleMapper workScheduleMapper) {
        this.workScheduleService = workScheduleService;
        this.workScheduleMapper = workScheduleMapper;
    }

    @PostMapping
    @ApiOperation(value="Create a work schedule",
            notes="Creates a work schedule based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The work schedule was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<WorkSchedule> create(
            @RequestBody
            @ApiParam(name = "schedule", value = "Work schedule details", required = true)
            WorkScheduleRequest workScheduleRequest)
    {
        WorkSchedule savedWorkSchedule = workScheduleService.create(workScheduleMapper.WorkScheduleRequestToWorkSchedule(workScheduleRequest));
        return ResponseEntity
                .created(URI.create("/schedules/"+savedWorkSchedule.getId()))
                .body(savedWorkSchedule);
    }
}

