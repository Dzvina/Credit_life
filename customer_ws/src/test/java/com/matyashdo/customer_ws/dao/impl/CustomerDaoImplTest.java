package com.matyashdo.customer_ws.dao.impl;

import com.matyashdo.customer_ws.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CustomerDaoImplTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private Customer customer = new Customer();

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private CustomerDaoImpl customerDaoImpl;

    @Captor
    ArgumentCaptor<Object[]> objectArray;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        customer.setCustomerId(CUSTOMER_ID);
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer.setPeselCustomer(PESEL_CUSTOMER);
    }

    @Test
    public void testAddCustomer() {
        String sql = "insert into customer (first_name_customer, last_name_customer, pesel_customer) values(?,?,?)";

        customerDaoImpl.addCustomer(customer);
        verify(jdbcTemplate).update(sql, customer.getFirstNameCustomer(), customer.getLastNameCustomer(), customer.getPeselCustomer());
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(new ArrayList<>());

        List<Customer> actualCustomerList = customerDaoImpl.getAllCustomers();
        Assert.assertEquals(customers, actualCustomerList);
    }

    @Test
    public void testGetCustomerById() {
        when(jdbcTemplate.queryForObject(anyString(), objectArray.capture(), any(BeanPropertyRowMapper.class))).thenReturn(customer);

        Customer actualCustomer = customerDaoImpl.getCustomerById(CUSTOMER_ID);
        Assert.assertEquals(customer, actualCustomer);
    }

    @Test
    public void testDeleteCustomerById() {
        String sql = "delete from customer where customer_id = ?";

        customerDaoImpl.deleteCustomerById(CUSTOMER_ID);
        verify(jdbcTemplate).update(sql, CUSTOMER_ID);
    }

    @Test
    public void testGetCustomerByPesel() {
        when(jdbcTemplate.queryForObject(anyString(), objectArray.capture(), any(BeanPropertyRowMapper.class))).thenReturn(customer);

        Customer actualCustomer = customerDaoImpl.getCustomerByPesel(PESEL_CUSTOMER);
        Assert.assertEquals(customer, actualCustomer);

    }
}