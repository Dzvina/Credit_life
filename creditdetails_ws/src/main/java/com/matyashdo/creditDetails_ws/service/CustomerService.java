package com.matyashdo.creditDetails_ws.service;

import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;

import java.util.List;

public interface CustomerService {

    void addCustomer(CustomerDto customerDto) throws ValidationException;

    CustomerDto getCustomerById(int customerId);

    CustomerDto getCustomerByPesel(String pesel) throws ValidationException;

    void deleteCustomerById(int customerId);

    List<CustomerDto> getAllCustomers();
}
