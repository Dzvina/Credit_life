package com.matyashdo.customer_ws.service.impl;

import com.matyashdo.customer_ws.dao.CustomerDao;
import com.matyashdo.customer_ws.dto.CustomerDto;
import com.matyashdo.customer_ws.model.Customer;
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

public class CustomerServiceImplTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private CustomerDto customerDto = new CustomerDto();
    private Customer expectedCustomer = new Customer();

    @Mock
    private CustomerDao customerDao;

    @InjectMocks
    private CustomerServiceImpl customerServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);

        expectedCustomer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        expectedCustomer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        expectedCustomer.setPeselCustomer(PESEL_CUSTOMER);
    }

    @Test
    public void testAddCustomer() {
        customerServiceImpl.addCustomer(customerDto);
        verify(customerDao).addCustomer(expectedCustomer);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> expectedCustomerList = new ArrayList<>();

        when(customerDao.getAllCustomers()).thenReturn(expectedCustomerList);

        List<Customer> actualCustomerList = customerServiceImpl.getAllCustomers();
        Assert.assertEquals(expectedCustomerList, actualCustomerList);
    }

    @Test
    public void testGetCustomerById() {
        when(customerDao.getCustomerById(CUSTOMER_ID)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerServiceImpl.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }

    @Test
    public void testDeleteCustomerById() {
        customerServiceImpl.deleteCustomerById(CUSTOMER_ID);
        verify(customerDao).deleteCustomerById(CUSTOMER_ID);
    }

    @Test
    public void testGetCustomerByPesel() {
        when(customerDao.getCustomerByPesel(PESEL_CUSTOMER)).thenReturn(expectedCustomer);

        Customer actualCustomer = customerServiceImpl.getCustomerByPesel(PESEL_CUSTOMER);
        Assert.assertEquals(expectedCustomer, actualCustomer);
    }
}