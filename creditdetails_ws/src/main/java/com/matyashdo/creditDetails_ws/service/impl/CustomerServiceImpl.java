package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClientCustomer;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import com.matyashdo.creditDetails_ws.utils.ValidationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private ValidationUtils validationUtils;

    @Autowired
    private RestClientCustomer restClientCustomer;

    @Override
    public void addCustomer(CustomerDto customerDto) throws ValidationException {
        LOGGER.info("Validate pesel");
        if (validationUtils.peselIsValid(customerDto.getPeselCustomer())) {
            if (restClientCustomer.getCustomerByPesel(customerDto.getPeselCustomer()) == null) {
                LOGGER.info("Sending create customer request to customer_ws");
                restClientCustomer.createCustomer(customerDto);
                LOGGER.info("Customer created successfully");
            } else {
                throw new ValidationException("Pesel already exists");
            }
        } else {
            throw new ValidationException("Pesel is not correct");
        }

    }

    @Override
    public CustomerDto getCustomerById(int customerId) {
        LOGGER.info("Sending get customer by id request to customer_ws");
        CustomerDto customerDto = restClientCustomer.getCustomerById(customerId);
        LOGGER.info("Received following customerDto in response: {}", customerDto);
        return customerDto;
    }

    @Override
    public CustomerDto getCustomerByPesel(String pesel) throws ValidationException {
        if (validationUtils.peselIsValid(pesel)) {
            LOGGER.info("Sending get customer by pesel request to customer_ws");
            CustomerDto customerDto = restClientCustomer.getCustomerByPesel(pesel);
            LOGGER.info("Received following customerDto in response: {}", customerDto);
            return customerDto;
        } else {
            throw new ValidationException("Pesel is not correct");
        }
    }

    @Override
    public void deleteCustomerById(int customerId) {
        LOGGER.info("Sending delete customer by id request to customer_ws");
        restClientCustomer.deleteCustomerById(customerId);
        LOGGER.info("Customer deleted successfully");
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        LOGGER.info("Sending get all customers request to customer_ws");
        List<CustomerDto> customerDto = restClientCustomer.getAllCustomers();
        LOGGER.info("Received following customerDto in response: {}", customerDto);
        return customerDto;
    }
}
