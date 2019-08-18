package com.matyashdo.customer_ws.controller;

import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
import com.matyashdo.customer_ws.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private CustomerDto customerDto = new CustomerDto();
    private Customer expectedCustomer = new Customer();

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedCustomer.setCustomerId(CUSTOMER_ID);
        expectedCustomer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        expectedCustomer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        expectedCustomer.setPeselCustomer(PESEL_CUSTOMER);
    }

    @Test
    public void testAddCustomer() {
        customerController.addCustomer(customerDto);
        verify(customerService).addCustomer(customerDto);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(expectedCustomer);

        when(customerService.getAllCustomers()).thenReturn(customers);

        List<Customer> actualCustomerList = customerController.getAllCustomers();
        Assert.assertEquals(customers, actualCustomerList);
    }

    @Test
    public void testGetCustomerById() {
        when(customerService.getCustomerById(CUSTOMER_ID)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerController.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void testDeleteCustomerById() {
        customerController.deleteCustomerById(CUSTOMER_ID);
        verify(customerService).deleteCustomerById(CUSTOMER_ID);
    }

    @Test
    public void testGetCustomerByPesel() {
        when(customerService.getCustomerByPesel(PESEL_CUSTOMER)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerController.getCustomerByPesel(PESEL_CUSTOMER);
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }
}