package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.dto.CustomerDto;
import com.matyashdo.creditDetails_ws.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class RestClient {

    private static final String CREDIT_BASE_URL = "http://localhost:8081";
    private static final String CREATE_CREDIT_PATH = "/api/v1/credits/create";
    private static final String GET_CREDIT_BY_ID_PATH = "/api/v1/credits/{0}";
    private static final String DELETE_CREDIT_PATH = "/api/v1/credits/{0}/delete";
    private static final String GET_CREDIT_BY_CUSTOMER_ID_PATH = "/api/v1/credits/{0}/customer";
    private static final String GET_CREDIT_BY_PRODUCT_ID_PATH = "/api/v1/credits/{0}/product";

    private static final String CUSTOMER_BASE_URL = "http://localhost:8082";
    private static final String CREATE_CUSTOMER_PATH = "/api/v1/customers/create";
    private static final String GET_CUSTOMER_BY_ID_PATH = "/api/v1/customers/{0}";
    private static final String GET_CUSTOMER_BY_PESEL_PATH = "/api/v1/customers/pesels/{0}";
    private static final String DELETE_CUSTOMER_PATH = "/api/v1/customers/{0}/delete";

    private static final String PRODUCT_BASE_URL = "http://localhost:8083";
    private static final String CREATE_PRODUCT_PATH = "/api/v1/products/create";
    private static final String GET_PRODUCT_BY_ID_PATH = "/api/v1/products/{0}";
    private static final String DELETE_PRODUCT_PATH = "/api/v1/products/{0}/delete";

    private static RestTemplate restTemplate = new RestTemplate();


    public static void createCredit(CreditDto creditDto) {
        String url = CREDIT_BASE_URL + CREATE_CREDIT_PATH;
        restTemplate.postForLocation(url, creditDto);
    }

    public static CreditDto getCreditById(int creditId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_ID_PATH, String.valueOf(creditId));
        ResponseEntity<CreditDto> creditResponseEntity = restTemplate.getForEntity(url, CreditDto.class);
        return creditResponseEntity.getBody();
    }

    public static void deleteCreditById(int creditId) {
        String url = CREDIT_BASE_URL + buildPath(DELETE_CREDIT_PATH, String.valueOf(creditId));
        restTemplate.delete(url);
    }

    public static List<CreditDto> getCreditsByCustomerId(int customerId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_CUSTOMER_ID_PATH, String.valueOf(customerId));
        List<CreditDto> creditDtos = (ArrayList<CreditDto>) restTemplate.getForObject(url, List.class);
        return creditDtos;
    }

    public static List<CreditDto> getCreditsByProductId(int productId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_PRODUCT_ID_PATH, String.valueOf(productId));
        List<CreditDto> creditDtos = (ArrayList<CreditDto>) restTemplate.getForObject(url, List.class);
        return  creditDtos;
    }


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


    public static void createProduct(ProductDto productDto) {
        String url = PRODUCT_BASE_URL + buildPath(CREATE_PRODUCT_PATH);
        restTemplate.postForLocation(url, productDto);
    }

    public static ProductDto getProductById(int productId) {
        String url = PRODUCT_BASE_URL + buildPath(GET_PRODUCT_BY_ID_PATH, String.valueOf(productId));
        ResponseEntity<ProductDto> productResponseEntity = restTemplate.getForEntity(url, ProductDto.class);
        return productResponseEntity.getBody();
    }

    public static void deleteProductById(int productId) {
        String url = PRODUCT_BASE_URL + buildPath(DELETE_PRODUCT_PATH, String.valueOf(productId));
        restTemplate.delete(url);
    }


    private static String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }

}
