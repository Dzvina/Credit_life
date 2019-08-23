package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClientCredit;
import com.matyashdo.creditDetails_ws.client.RestClientCustomer;
import com.matyashdo.creditDetails_ws.dto.CreditDto;
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


public class CreditServiceImplTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";

    private CreditDto creditDto = new CreditDto();

    @Mock
    private RestClientCredit restClientCredit;

    @InjectMocks
    private CreditServiceImpl creditServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

    }

    @Test
    public void testAddCredit() {
        creditServiceImpl.addCredit(creditDto);
        verify(restClientCredit).createCredit(creditDto);
    }

    @Test
    public void testGetCreditById() {
        when(restClientCredit.getCreditById(CREDIT_ID)).thenReturn(creditDto);

        CreditDto actualCredit = creditServiceImpl.getCreditById(CREDIT_ID);

        Assert.assertEquals(creditDto, actualCredit);
    }

    @Test
    public void testDeleteCreditById() {
        creditServiceImpl.deleteCreditById(CREDIT_ID);
        verify(restClientCredit).deleteCreditById(CREDIT_ID);
    }

    @Test
    public void testGetCreditByCustomerId() {
        List<CreditDto> credits = new ArrayList<>();

        when(restClientCredit.getCreditsByCustomerId(CUSTOMER_ID)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditList = creditServiceImpl.getCreditByCustomerId(CUSTOMER_ID);
        Assert.assertEquals(credits, actualCreditList);
    }

    @Test
    public void testGetCreditByProductId() {
        List<CreditDto> credits = new ArrayList<>();

        when(restClientCredit.getCreditsByProductId(PRODUCT_ID)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditList = creditServiceImpl.getCreditByProductId(PRODUCT_ID);
        Assert.assertEquals(credits, actualCreditList);
    }
}