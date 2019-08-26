package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.controller.CustomerController;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestClientCustomerTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    private static final String CREATE_CUSTOMER_URL = "http://localhost:8082/api/v1/customers/create";
    private static final String GET_CUSTOMER_BY_ID_URL = "http://localhost:8082/api/v1/customers/1";
    private static final String GET_CUSTOMER_BY_PESEL_URL = "http://localhost:8082/api/v1/customers/pesels/12345678901";
    private static final String DELETE_CUSTOMER_URL = "http://localhost:8082/api/v1/customers/1/delete";
    private static final String GET_ALL_CUSTOMER_URL = "http://localhost:8082/api/v1/customers";

    private CustomerDto customerDto = new CustomerDto();

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestClientCustomer restClientCustomer;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
    }

    @Test
    public void createCustomer() {
        restClientCustomer.createCustomer(customerDto);
        verify(restTemplate).postForLocation(CREATE_CUSTOMER_URL, customerDto);
    }

    @Test
    public void getCustomerById() {
        ResponseEntity<CustomerDto> responseEntity = new ResponseEntity<>(customerDto, HttpStatus.OK);

        when(restTemplate.getForEntity(GET_CUSTOMER_BY_ID_URL,CustomerDto.class)).thenReturn(responseEntity);
        CustomerDto actualCustomerDto = restClientCustomer.getCustomerById(CUSTOMER_ID);

        Assert.assertEquals(customerDto,actualCustomerDto);
    }

    @Test
    public void getCustomerByPesel() {
        ResponseEntity<CustomerDto> responseEntity = new ResponseEntity<>(customerDto, HttpStatus.OK);

        when(restTemplate.getForEntity(GET_CUSTOMER_BY_PESEL_URL,CustomerDto.class)).thenReturn(responseEntity);
        CustomerDto actualCustomerDto = restClientCustomer.getCustomerByPesel(PESEL_CUSTOMER);

        Assert.assertEquals(customerDto,actualCustomerDto);
    }

    @Test
    public void deleteCustomerById() {
        restClientCustomer.deleteCustomerById(CUSTOMER_ID);
        verify(restTemplate).delete(DELETE_CUSTOMER_URL);
    }

    @Test
    public void testGetAllCustomers() {
        List<CustomerDto> expectedCustomerDtoList = new ArrayList<>();

        when(restTemplate.getForObject(GET_ALL_CUSTOMER_URL, List.class)).thenReturn(new ArrayList<>());

        List<CustomerDto> actualCustomerDtoList = restClientCustomer.getAllCustomers();

        Assert.assertEquals(expectedCustomerDtoList, actualCustomerDtoList);
    }
}