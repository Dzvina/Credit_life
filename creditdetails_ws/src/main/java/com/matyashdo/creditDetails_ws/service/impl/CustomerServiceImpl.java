package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer(CustomerDto customerDto) {
        RestClient.createCustomer(customerDto);
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        return RestClient.getCustomerById(customerId);
    }

    @Override
    public CustomerDto getCustomerByPesel(String pesel) {
        return RestClient.getCustomerByPesel(pesel);
    }

    @Override
    public void deleteCustomerById(int customerId) {
        RestClient.deleteCustomerById(customerId);
    }
}
