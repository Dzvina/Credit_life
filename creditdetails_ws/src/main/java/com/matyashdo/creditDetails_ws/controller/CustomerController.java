package com.matyashdo.creditDetails_ws.controller;


import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerDto customerDto) throws ValidationException {
        LOGGER.info("Received request for get all customers");
        customerService.addCustomer(customerDto);
        LOGGER.info("Customer was successfully created");
    }

    @GetMapping(value = "/{customerId}")
    public CustomerDto getCustomerById(@PathVariable(value = "customerId") int customerId) {
        LOGGER.info("Received request for get customer by id");
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        LOGGER.info("Customer: {} was successfully fetched", customerDto);
        return customerDto;
    }

    @GetMapping(value = "/pesels/{pesel}")
    public CustomerDto getCustomerByPesel(@PathVariable(value = "pesel") String pesel) throws ValidationException {
        LOGGER.info("Received request for get customer by pesel");
        CustomerDto customerDto = customerService.getCustomerByPesel(pesel);
        LOGGER.info("Customer: {} was successfully fetched", customerDto);
        return customerDto;
    }

    @DeleteMapping(value = "/{customerId}/delete")
    public void deleteCustomerById(@PathVariable(value = "customerId") int customerId) {
        LOGGER.info("Received request for customer deletion");
        customerService.deleteCustomerById(customerId);
        LOGGER.info("Customer was successfully deleted");
    }

    @GetMapping
    public List<CustomerDto> getAllCustomers(){
        LOGGER.info("Received request for get all customers");
        List<CustomerDto> customerDto = customerService.getAllCustomers();
        LOGGER.info("Customers: {} was successfully fetched", customerDto);
        return customerDto;
    }
}
