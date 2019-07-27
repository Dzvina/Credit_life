package com.matyashdo.customer_ws.controller;

import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addCustomer(customerDto);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @DeleteMapping(value = "/{customerId}/delete")
    public void deleteCustomerById(@PathVariable("customerId") int customerId) {
        customerService.deleteCustomerById(customerId);
    }

    @GetMapping(value = "/pesels/{pesel}")
    public Customer getCustomerByPesel(@PathVariable(value = "pesel") String pesel){
        return customerService.getCustomerByPesel(pesel);
    }
}
