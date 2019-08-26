package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientCustomer {

    private static final String CUSTOMER_BASE_URL = "http://localhost:8082";
    private static final String CREATE_CUSTOMER_PATH = "/api/v1/customers/create";
    private static final String GET_CUSTOMER_BY_ID_PATH = "/api/v1/customers/{0}";
    private static final String GET_CUSTOMER_BY_PESEL_PATH = "/api/v1/customers/pesels/{0}";
    private static final String DELETE_CUSTOMER_PATH = "/api/v1/customers/{0}/delete";
    private static final String GET_ALL_CUSTOMERS_PATH = "/api/v1/customers";

    @Autowired
    private RestTemplate restTemplate;

    public void createCustomer(CustomerDto customerDto) {
        String url = CUSTOMER_BASE_URL + CREATE_CUSTOMER_PATH;
        restTemplate.postForLocation(url, customerDto);
    }

    public CustomerDto getCustomerById(int customerId) {
        String url = CUSTOMER_BASE_URL + buildPath(GET_CUSTOMER_BY_ID_PATH, String.valueOf(customerId));
        ResponseEntity<CustomerDto> customerResponseEntity = restTemplate.getForEntity(url, CustomerDto.class);
        return customerResponseEntity.getBody();
    }

    public CustomerDto getCustomerByPesel(String custmerPesel) {
        String url = CUSTOMER_BASE_URL + buildPath(GET_CUSTOMER_BY_PESEL_PATH, custmerPesel);
        ResponseEntity<CustomerDto> customerDtoResponseEntity = restTemplate.getForEntity(url, CustomerDto.class);
        return customerDtoResponseEntity.getBody();
    }

    public void deleteCustomerById(int customerId) {
        String url = CUSTOMER_BASE_URL + buildPath(DELETE_CUSTOMER_PATH, String.valueOf(customerId));
        restTemplate.delete(url);
    }

    public List<CustomerDto> getAllCustomers(){
        String url = CUSTOMER_BASE_URL + GET_ALL_CUSTOMERS_PATH;
        List<CustomerDto> customerDtos = (ArrayList<CustomerDto>) restTemplate.getForObject(url, List.class);
        return customerDtos;
    }


    private String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }
}
