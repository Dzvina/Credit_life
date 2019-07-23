package com.matyashdo.credit_ws.client;

import com.matyashdo.credit_ws.dto.Customer;
import com.matyashdo.credit_ws.dto.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

public class RestClient {

    private static final String CUSTOMER_BASE_URL = "http://localhost:8082/customer";
    private static final String CREATE_CUSTOMER_PATH = "/creditId/{0}/firstNameCustomer/{1}/lastNameCustomer/{2}/peselCustomer/{3}/create";
    private static final String GET_CUSTOMER_PATH = "/creditId/{0}/getCustomer";

    private static final String PRODUCT_BASE_URL = "http://localhost:8083/product";
    private static final String CREATE_PRODUCT_PATH = "/creditId/{0}/productName/{1}/value/{2}/create";
    private static final String GET_PRODUCT_PATH = "/creditId/{0}/getProduct";

    private static RestTemplate restTemplate = new RestTemplate();

    public static void createCustomer(int creditId, String firstNameCstomer, String lastNameCustomer, String pesel) {
        String url = CUSTOMER_BASE_URL + buildPath(CREATE_CUSTOMER_PATH, String.valueOf(creditId), firstNameCstomer, lastNameCustomer, pesel);
        restTemplate.postForLocation(url, null);
    }

    public static void createProduct(int creditId, String productName, int value) {
        String url = PRODUCT_BASE_URL + buildPath(CREATE_PRODUCT_PATH, String.valueOf(creditId), productName, String.valueOf(value));
        restTemplate.postForLocation(url, null);
    }

    public static Customer getCustomer(int creditId) {
        String url = CUSTOMER_BASE_URL + buildPath(GET_CUSTOMER_PATH, String.valueOf(creditId));
        ResponseEntity<Customer> customerResponseEntity = restTemplate.getForEntity(url, Customer.class);
        return customerResponseEntity.getBody();
    }

    public static Product getProduct(int creditId) {
        String url = PRODUCT_BASE_URL + buildPath(GET_PRODUCT_PATH, String.valueOf(creditId));
        ResponseEntity<Product> productResponseEntity = restTemplate.getForEntity(url, Product.class);
        return productResponseEntity.getBody();
    }

    private static String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }
}
