package com.matyashdo.creditDetails_ws.controller;


import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create")
    public void addCustomer(@RequestBody CustomerDto customerDto) throws ValidationException {
        customerService.addCustomer(customerDto);
    }

    @GetMapping(value = "/{customerId}")
    public CustomerDto getCustomerById(@PathVariable(value = "customerId") int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping(value = "/pesels/{pesel}")
    public CustomerDto getCustomerByPesel(@PathVariable(value = "pesel") String pesel) throws ValidationException {
        return customerService.getCustomerByPesel(pesel);
    }

    @DeleteMapping(value = "/{customerId}/delete")
    public void deleteCustomerById(@PathVariable(value = "customerId") int customerId){
        customerService.deleteCustomerById(customerId);
    }
}
