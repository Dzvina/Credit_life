package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.service.CreditService;
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

public class CreditControllerTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";

    private CreditDto creditDto = new CreditDto();

    @Mock
    private CreditService creditService;

    @InjectMocks
    private CreditController creditController;

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
        creditController.addCredit(creditDto);
        verify(creditService).addCredit(creditDto);
    }

    @Test
    public void testGetCreditById() {
        when(creditService.getCreditById(CREDIT_ID)).thenReturn(creditDto);

        CreditDto actualCreditDto = creditController.getCreditById(CREDIT_ID);
        Assert.assertEquals(creditDto, actualCreditDto);
    }

    @Test
    public void testDeleteCreditById() {
        creditController.deleteCreditById(CREDIT_ID);
        verify(creditService).deleteCreditById(CREDIT_ID);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        List<CreditDto> creditDtos = new ArrayList<>();

        when(creditService.getCreditByCustomerId(CUSTOMER_ID)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = creditController.getCreditsByCustomerId(CUSTOMER_ID);
        Assert.assertEquals(creditDtos, actualCreditDtoList);
    }

    @Test
    public void testGetCreditsByProductId() {
        List<CreditDto> creditDtos = new ArrayList<>();

        when(creditService.getCreditByProductId(PRODUCT_ID)).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = creditController.getCreditsByProductId(PRODUCT_ID);
        Assert.assertEquals(creditDtos, actualCreditDtoList);
    }

    @Test
    public void testGetAllCredits() {
        List<CreditDto> creditDtos = new ArrayList<>();

        when(creditService.getAllCredits()).thenReturn(new ArrayList<>());

        List<CreditDto> actualCreditDtoList = creditController.getAllCredits();
        Assert.assertEquals(creditDtos, actualCreditDtoList);
    }
}