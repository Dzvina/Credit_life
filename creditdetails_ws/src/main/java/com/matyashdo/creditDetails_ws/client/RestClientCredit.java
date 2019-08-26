package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientCredit {

    private static final String CREDIT_BASE_URL = "http://localhost:8081";
    private static final String CREATE_CREDIT_PATH = "/api/v1/credits/create";
    private static final String GET_CREDIT_BY_ID_PATH = "/api/v1/credits/{0}";
    private static final String DELETE_CREDIT_PATH = "/api/v1/credits/{0}/delete";
    private static final String GET_CREDIT_BY_CUSTOMER_ID_PATH = "/api/v1/credits/{0}/customer";
    private static final String GET_CREDIT_BY_PRODUCT_ID_PATH = "/api/v1/credits/{0}/product";
    private static final String GET_ALL_CREDITS_PATH = "/api/v1/credits";

    @Autowired
    private RestTemplate restTemplate;

    public void createCredit(CreditDto creditDto) {
        String url = CREDIT_BASE_URL + CREATE_CREDIT_PATH;
        restTemplate.postForLocation(url, creditDto);
    }

    public CreditDto getCreditById(int creditId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_ID_PATH, String.valueOf(creditId));
        ResponseEntity<CreditDto> creditResponseEntity = restTemplate.getForEntity(url, CreditDto.class);
        return creditResponseEntity.getBody();
    }

    public void deleteCreditById(int creditId) {
        String url = CREDIT_BASE_URL + buildPath(DELETE_CREDIT_PATH, String.valueOf(creditId));
        restTemplate.delete(url);
    }

    public List<CreditDto> getCreditsByCustomerId(int customerId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_CUSTOMER_ID_PATH, String.valueOf(customerId));
        List<CreditDto> creditDtos = (ArrayList<CreditDto>) restTemplate.getForObject(url, List.class);
        return creditDtos;
    }

    public List<CreditDto> getCreditsByProductId(int productId) {
        String url = CREDIT_BASE_URL + buildPath(GET_CREDIT_BY_PRODUCT_ID_PATH, String.valueOf(productId));
        List<CreditDto> creditDtos = (ArrayList<CreditDto>) restTemplate.getForObject(url, List.class);
        return  creditDtos;
    }

    public List<CreditDto> getAllCredits(){
       String url = CREDIT_BASE_URL + GET_ALL_CREDITS_PATH;
       List<CreditDto> creditDtos = (ArrayList<CreditDto>) restTemplate.getForObject(url, List.class);
        return creditDtos;
    }

    private String buildPath(String pathTemplate, String... args) {
        String resourcePath = MessageFormat.format(pathTemplate, args);
        return resourcePath;
    }
}
