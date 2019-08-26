package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClientCustomer;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.exception.ValidationException;
import com.matyashdo.creditDetails_ws.utils.ValidationUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerServiceImplTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private CustomerDto customerDto = new CustomerDto();

    @Mock
    private RestClientCustomer restClientCustomer;

    @Mock
    private ValidationUtils validationUtils;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
    }


    @Test(expected = ValidationException.class)
    public void testAddCustomerThrowsExceptionWhenPeselNotValid() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(false);
        customerServiceImpl.addCustomer(customerDto);
    }

    @Test(expected = ValidationException.class)
    public void testAddCustomerThrowsExceptionWhenPeselIsValidAndCustomerExists() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(true);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
        when(restClientCustomer.getCustomerByPesel(PESEL_CUSTOMER)).thenReturn(customerDto);
        customerServiceImpl.addCustomer(customerDto);
    }

    @Test
    public void testAddCustomerWhenPeselIsCorrectAndCustomerNotExist() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(true);
        when(restClientCustomer.getCustomerByPesel(null)).thenReturn(customerDto);
        customerServiceImpl.addCustomer(customerDto);
        verify(restClientCustomer).createCustomer(customerDto);
    }

    @Test
    public void testGetCustomerById() {
        when(restClientCustomer.getCustomerById(CUSTOMER_ID)).thenReturn(customerDto);

        CustomerDto actualCustomer = customerServiceImpl.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(customerDto, actualCustomer);
    }

    @Test(expected = ValidationException.class)
    public void testGetCustomerByPeselThrowsExceptionWhenPeselNotValid() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(false);
        customerServiceImpl.getCustomerByPesel(PESEL_CUSTOMER);
    }

    @Test
    public void testGetCustomerByPeselWhenPeselValid() throws ValidationException {
        when(validationUtils.peselIsValid(PESEL_CUSTOMER)).thenReturn(true);
        customerServiceImpl.getCustomerByPesel(PESEL_CUSTOMER);
        verify(restClientCustomer).getCustomerByPesel(PESEL_CUSTOMER);
    }


    @Test
    public void testDeleteCustomerById() {
        customerServiceImpl.deleteCustomerById(CUSTOMER_ID);
        verify(restClientCustomer).deleteCustomerById(CUSTOMER_ID);
    }

    @Test
    public void testGetAllCustomers(){
        List<CustomerDto> customerDtos = new ArrayList<>();

        when(restClientCustomer.getAllCustomers()).thenReturn(new ArrayList<>());

        List<CustomerDto> actualCustomersList = customerServiceImpl.getAllCustomers();
        Assert.assertEquals(customerDtos, actualCustomersList);
    }
}