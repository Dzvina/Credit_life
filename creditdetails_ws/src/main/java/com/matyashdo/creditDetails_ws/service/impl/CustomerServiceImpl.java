package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import com.matyashdo.creditDetails_ws.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ValidationUtils validationUtils;

    @Override
    public void addCustomer(CustomerDto customerDto) throws ValidationException {
        if (validationUtils.peselIsValid(customerDto.getPeselCustomer())) {
            if (RestClient.getCustomerByPesel(customerDto.getPeselCustomer()) == null) {
                RestClient.createCustomer(customerDto);
            } else {
                throw new ValidationException("Pesel already exists");
            }
        } else {
            throw new ValidationException("Pesel is not correct");
        }
    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        return RestClient.getCustomerById(customerId);
    }

    @Override
    public CustomerDto getCustomerByPesel(String pesel) throws ValidationException {
        if (validationUtils.peselIsValid(pesel)) {
            return RestClient.getCustomerByPesel(pesel);
        } else {
            throw new ValidationException("Pesel is not correct");
        }
    }

    @Override
    public void deleteCustomerById(int customerId) {
        RestClient.deleteCustomerById(customerId);
    }
}
