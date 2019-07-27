package com.matyashdo.creditDetails_ws.service;

import com.matyashdo.creditDetails_ws.dto.CustomerDto;

public interface CustomerService {

    void addCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(int customerId);

    CustomerDto getCustomerByPesel(String pesel);

    void deleteCustomer(int customerId);
}
