package com.matyashdo.creditDetails_ws.client;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RestClientCreditTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";

    private static final String CREATE_CREDIT_URL = "http://localhost:8081/api/v1/credits/create";
    private static final String GET_CREDIT_BY_ID_URL = "http://localhost:8081/api/v1/credits/1";
    private static final String DELETE_CREDIT_URL = "http://localhost:8081/api/v1/credits/1/delete";
    private static final String GET_CREDIT_BY_CUSTOMER_ID_URL = "http://localhost:8081/api/v1/credits/1/customer";
    private static final String GET_CREDIT_BY_PRODUCT_ID_URL = "http://localhost:8081/api/v1/credits/1/product";
    private static final String GET_ALL_CREDITS_URL = "http://localhost:8081/api/v1/credits";

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
        restClientCredit.createCredit(creditDto);
        verify(restTemplate).postForLocation(CREATE_CREDIT_URL, creditDto);
    }

    @Test
    public void testGetCreditById() {
        ResponseEntity<CreditDto> responseEntity = new ResponseEntity(creditDto, HttpStatus.OK);

        when(restTemplate.getForEntity(GET_CREDIT_BY_ID_URL, CreditDto.class)).thenReturn(responseEntity);
        CreditDto actualCreditDto = restClientCredit.getCreditById(CREDIT_ID);

        Assert.assertEquals(creditDto, actualCreditDto);
    }

    @Test
    public void testDeleteCreditById() {
        restClientCredit.deleteCreditById(CREDIT_ID);
        verify(restTemplate).delete(DELETE_CREDIT_URL);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        List<CreditDto> expectedCreditDtoList = new ArrayList<>();

        when(restTemplate.getForObject(GET_CREDIT_BY_CUSTOMER_ID_URL, List.class)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = restClientCredit.getCreditsByCustomerId(CUSTOMER_ID);

        Assert.assertEquals(expectedCreditDtoList, actualCreditDtoList);
    }

    @Test
    public void testGetCreditsByProductId() {
        List<CreditDto> expectedCreditDtoList = new ArrayList<>();

        when(restTemplate.getForObject(GET_CREDIT_BY_PRODUCT_ID_URL, List.class)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = restClientCredit.getCreditsByProductId(PRODUCT_ID);

        Assert.assertEquals(expectedCreditDtoList, actualCreditDtoList);
    }

    @Test
    public void testGetAllCredits() {
        List<CreditDto> expectedCreditDtoList = new ArrayList<>();

        when(restTemplate.getForObject(GET_ALL_CREDITS_URL, List.class)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = restClientCredit.getAllCredits();

        Assert.assertEquals(expectedCreditDtoList, actualCreditDtoList);
    }
}