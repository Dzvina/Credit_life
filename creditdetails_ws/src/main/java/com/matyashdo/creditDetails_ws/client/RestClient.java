package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

public class RestClient {

    private static final String CREDIT_BASE_URL = "http://localhost:8081/credit";
    private static final String CREATE_CREDIT_PATH = "/nameCredit/{0}/create";
    private static final String GET_CREDIT_PATH = "/creditId/{0}/getCredit";

    private static final String CUSTOMER_BASE_URL = "http://localhost:8082";
    private static final String CREATE_CUSTOMER_PATH = "/api/v1/customers/create";
    private static final String GET_CUSTOMER_BY_ID_PATH = "/api/v1/customers/{0}";
    private static final String GET_CUSTOMER_BY_PESEL_PATH = "/api/v1/customers/pesels/{0}";
    private static final String DELETE_CUSTOMER_PATH = "/api/v1/customers/{0}/delete";

    private static final String PRODUCT_BASE_URL = "http://localhost:8083/product";
    private static final String CREATE_PRODUCT_PATH = "/productName/{0}/value/{1}/create";
    private static final String GET_PRODUCT_PATH = "/creditId/{0}/getProduct";

    private static RestTemplate restTemplate = new RestTemplate();


    public static void createCustomer(CustomerDto customerDto) {
        String url = CUSTOMER_BASE_URL + CREATE_CUSTOMER_PATH;
        restTemplate.postForLocation(url, customerDto);
    }

    public static CustomerDto getCustomerById(int customerId) {
        String url = CUSTOMER_BASE_URL + buildPath(GET_CUSTOMER_BY_ID_PATH, String.valueOf(customerId));
        ResponseEntity<CustomerDto> customerResponseEntity = restTemplate.getForEntity(url, CustomerDto.class);
        return customerResponseEntity.getBody();
    }

    public static CustomerDto getCustomerByPesel(String custmerPesel) {
        String url = CUSTOMER_BASE_URL + buildPath(GET_CUSTOMER_BY_PESEL_PATH, custmerPesel);
        ResponseEntity<CustomerDto> customerDtoResponseEntity = restTemplate.getForEntity(url, CustomerDto.class);
        return customerDtoResponseEntity.getBody();
    }

    public static void deleteCustomerById(int customerId) {
        String url = CUSTOMER_BASE_URL + buildPath(DELETE_CUSTOMER_PATH, String.valueOf(customerId));
        restTemplate.delete(url);
    }


    public static ProductDto getProduct(int creditId) {
        String url = PRODUCT_BASE_URL + buildPath(GET_PRODUCT_PATH, String.valueOf(creditId));
        ResponseEntity<ProductDto> productResponseEntity = restTemplate.getForEntity(url, ProductDto.class);
        return productResponseEntity.getBody();
    }

    public static void createProduct(int creditId, String productName, int value) {
        String url = PRODUCT_BASE_URL + buildPath(CREATE_PRODUCT_PATH, String.valueOf(creditId), productName, String.valueOf(value));
        restTemplate.postForLocation(url, null);
    }


    public static void createCredit(int creditId, String nameCredit) {
        String url = CREDIT_BASE_URL + buildPath(CREATE_CREDIT_PATH, String.valueOf(creditId), nameCredit);
        restTemplate.postForLocation(url, null);
    }

    public static CreditDto getCredit(int creditId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_PATH, String.valueOf(creditId));
        ResponseEntity<CreditDto> creditResponseEntity = restTemplate.getForEntity(url, CreditDto.class);
        return creditResponseEntity.getBody();
    }


    private static String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }
}
