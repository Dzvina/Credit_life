package com.matyashdo.creditDetails_ws.controller;


import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    @GetMapping(value = "/{customerId}")
    public CustomerDto getCustomerById(@PathVariable(value = "customerId") int customerId) {
        return customerService.getCustomerById(customerId);
    }

}
