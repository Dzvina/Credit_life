package com.matyashdo.customer_ws.controller;

import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
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
    CustomerService customerService;

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        LOGGER.info("Received request for customer creation");
        customerService.addCustomer(customerDto);
        LOGGER.info("Customer was successfully created");
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        LOGGER.info("Received request for get all customers");
        List<Customer> customer = customerService.getAllCustomers();
        LOGGER.info("Customers were successfully fetched: {}", customer);
        return customer;
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        LOGGER.info("Received request for get customer by id");
        Customer customer = customerService.getCustomerById(customerId);
        LOGGER.info("Customer: {} was successfully fetched", customer);
        return customer;
    }

    @DeleteMapping(value = "/{customerId}/delete")
    public void deleteCustomerById(@PathVariable("customerId") int customerId) {
        LOGGER.info("Received request for customer deletion");
        customerService.deleteCustomerById(customerId);
        LOGGER.info("Customer was successfully deleted");
    }

    @GetMapping(value = "/pesels/{pesel}")
    public Customer getCustomerByPesel(@PathVariable(value = "pesel") String pesel){
        LOGGER.info("Received request for get customer by pesel");
        Customer customer = customerService.getCustomerByPesel(pesel);
        LOGGER.info("Customer: {} was successfully fetched", customer);
        return customer;
    }
}
