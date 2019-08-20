package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private CustomerDto customerDto = new CustomerDto();

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
    }

    @Test
    public void testAddCustomer() throws ValidationException {
        customerController.addCustomer(customerDto);
        verify(customerService).addCustomer(customerDto);
    }

    @Test
    public void testGetCustomerById() {
        when(customerService.getCustomerById(CUSTOMER_ID)).thenReturn(customerDto);

        CustomerDto actualCustomerDto = customerController.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(customerDto, actualCustomerDto);
    }

    @Test
    public void testGetCustomerByPesel() throws ValidationException {
        when(customerService.getCustomerByPesel(PESEL_CUSTOMER)).thenReturn(customerDto);

        CustomerDto actualCustomerDto = customerController.getCustomerByPesel(PESEL_CUSTOMER);
        Assert.assertEquals(customerDto, actualCustomerDto);
    }

    @Test
    public void testDeleteCustomerById() {
        customerController.deleteCustomerById(CUSTOMER_ID);
        verify(customerService).deleteCustomerById(CUSTOMER_ID);
    }
}