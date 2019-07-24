package com.matyashdo.customer_ws.controller;

import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/creditId/{creditId}/firstNameCustomer/{firstNameCustomer}/lastNameCustomer/{lastNameCustomer}/peselCustomer/{peselCustomer}/create")
    public void addCustomer(@PathVariable("creditId") int creditId,
                            @PathVariable("firstNameCustomer") String firstNameCustomer,
                            @PathVariable("lastNameCustomer") String lastNameCustomer,
                            @PathVariable("peselCustomer") String peselCustomer) {
        Customer customer = new Customer(creditId,firstNameCustomer,lastNameCustomer,peselCustomer);
        customerService.addCustomer(customer);
    }

    @GetMapping(value = "/creditId/{creditId}/getCustomer")
    public Customer getCustomer(@PathVariable("creditId")int creditId) {
        return customerService.getCustomer(creditId);
    }

    @GetMapping(value = "/creditId/{customerId}/getCreditIds")
    public List<Integer> getCreditIdsByCustomerId(@PathVariable("customerId")int customerId){
        List<Integer> creditId = customerService.getCreditIdsByCustomerId(customerId);
        return creditId;
    }
}
