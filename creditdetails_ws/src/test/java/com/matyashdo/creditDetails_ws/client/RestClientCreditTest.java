package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RestClientCreditTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";

    private static final String CREDIT_BASE_URL = "http://localhost:8081";
    private static final String CREATE_CREDIT_PATH = "/api/v1/credits/create";
    private static final String GET_CREDIT_BY_ID_PATH = "/api/v1/credits/{0}";
    private static final String DELETE_CREDIT_PATH = "/api/v1/credits/{0}/delete";
    private static final String GET_CREDIT_BY_CUSTOMER_ID_PATH = "/api/v1/credits/{0}/customer";
    private static final String GET_CREDIT_BY_PRODUCT_ID_PATH = "/api/v1/credits/{0}/product";

    private CreditDto creditDto = new CreditDto();

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RestClientCredit restClientCredit;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

    }

    @Test
    public void testCreateCredit() {
        String url = CREDIT_BASE_URL + CREATE_CREDIT_PATH;
        restClientCredit.createCredit(creditDto);
        verify(restTemplate).postForLocation(url,creditDto);
    }

    @Test
    public void testGetCreditById() {
    }

    @Test
    public void testDeleteCreditById() {
    }

    @Test
    public void testGetCreditsByCustomerId() {
    }

    @Test
    public void testGetCreditsByProductId() {
    }
}