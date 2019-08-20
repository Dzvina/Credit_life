package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClientCredit;
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

import javax.validation.Validation;

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

    @Test
    public void addCustomer() {
    }

    @Test(expected = ValidationException.class)
    public void TestAddCustomerThrowsExceptionWhenPeselNotValid() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(false);
        customerServiceImpl.addCustomer(customerDto);
    }

    @Test(expected = ValidationException.class)
    public void TestAddCustomerThrowsExceptionWhenPeselValid() throws ValidationException {
        when(validationUtils.peselIsValid(anyString())).thenReturn(true);
        customerServiceImpl.addCustomer(customerDto);
    }


    @Test
    public void getCustomerById() {
        when(restClientCustomer.getCustomerById(CUSTOMER_ID)).thenReturn(customerDto);

        CustomerDto actualCustomer = customerServiceImpl.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(customerDto, actualCustomer);
    }

    @Test
    public void getCustomerByPesel() {

    }

    @Test
    public void deleteCustomerById() {
        customerServiceImpl.deleteCustomerById(CUSTOMER_ID);
        verify(restClientCustomer).deleteCustomerById(CUSTOMER_ID);
    }
}