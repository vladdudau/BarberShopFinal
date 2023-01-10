package com.unibuc.project.barbershop.controller;

import com.unibuc.project.barbershop.dto.CustomerRequest;
import com.unibuc.project.barbershop.mapper.CustomerMapper;
import com.unibuc.project.barbershop.model.Customer;
import com.unibuc.project.barbershop.service.CustomerService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/customers")
@Api(value="/customers", tags = "Customers")
public class CustomerController {

    private CustomerService customerService;

    private CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    @ApiOperation(value="Create a customer",
            notes="Creates a customer based on the information received in the request")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The customer was successfully created based on the received request"),
            @ApiResponse(code = 400, message = "Validation error on the received request")
    })
    public ResponseEntity<Customer> create(
            @RequestBody
            @ApiParam(name = "customer", value = "Customer details", required = true)
            CustomerRequest customerRequest)
    {
        Customer savedCustomer = customerService.create(customerMapper.CustomerRequestToCustomer(customerRequest));
        return ResponseEntity
                .created(URI.create("/customers/"+savedCustomer.getId()))
                .body(savedCustomer);
    }
}
