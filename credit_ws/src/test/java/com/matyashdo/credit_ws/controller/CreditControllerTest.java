package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CreditControllerTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";
    CreditDto creditDto = new CreditDto();
    Credit credit = new Credit();

    @Mock
    private CreditService creditService;

    @InjectMocks
    private CreditController creditController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCredit() {
        doNothing().when(creditService).addCredit(any(CreditDto.class));
        creditController.addCredit(creditDto);
        verify(creditService).addCredit(creditDto);
    }

    @Test
    public void testGetAllCredits() {
        credit.setCreditId(CREDIT_ID);
        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);
        List<Credit> credits = new ArrayList<>();
        credits.add(credit);
        when(creditService.getAllCredits()).thenReturn(credits);
        List<Credit> actualCreditsList = creditController.getAllCredits();
        Assert.assertEquals(credits, actualCreditsList);
    }

    @Test
    public void testGetCreditById() {
        credit.setCreditId(CREDIT_ID);
        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);

        Credit credit1 = new Credit();
        credit1.setCreditId(CREDIT_ID);
        credit1.setCustomerId(CUSTOMER_ID);
        credit1.setProductId(PRODUCT_ID);
        credit1.setNameCredit(NAME_CREDIT);
        when(creditService.getCreditById(CREDIT_ID)).thenReturn(credit);
        Assert.assertEquals(credit, credit1);
    }

    @Test
    public void testDeleteCreditById() {
        doNothing().when(creditService).deleteCreditById(CREDIT_ID);
        creditController.deleteCreditById(CREDIT_ID);
        verify(creditService).deleteCreditById(CREDIT_ID);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        credit.setCreditId(CREDIT_ID);
        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);
        List<Credit> credits = new ArrayList<>();
        credits.add(credit);
        when(creditService.getCreditsByCustomerId(CUSTOMER_ID)).thenReturn(credits);
        List<Credit> credits1 = creditController.getCreditsByCustomerId(CUSTOMER_ID);
        Assert.assertEquals(credits, credits1);
    }

    @Test
    public void testGetCreditsByProductId() {
        credit.setCreditId(CREDIT_ID);
        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);
        List<Credit> credits = new ArrayList<>();
        credits.add(credit);
        when(creditService.getCreditsByProductId(PRODUCT_ID)).thenReturn(credits);
        List<Credit> credits1 = creditController.getCreditsByProductId(PRODUCT_ID);
        Assert.assertEquals(credits, credits1);
    }
}