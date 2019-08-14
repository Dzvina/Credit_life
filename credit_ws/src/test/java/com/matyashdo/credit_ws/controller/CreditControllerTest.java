package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
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
    private Credit expectedCredit = new Credit();

    @Mock
    private CreditService creditService;

    @InjectMocks
    private CreditController creditController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedCredit.setCreditId(CREDIT_ID);
        expectedCredit.setCustomerId(CUSTOMER_ID);
        expectedCredit.setProductId(PRODUCT_ID);
        expectedCredit.setNameCredit(NAME_CREDIT);
    }

    @Test
    public void testAddCredit() {
        creditController.addCredit(creditDto);
        verify(creditService).addCredit(creditDto);
    }

    @Test
    public void testGetAllCredits() {
        List<Credit> credits = new ArrayList<>();
        credits.add(expectedCredit);

        when(creditService.getAllCredits()).thenReturn(credits);

        List<Credit> actualCreditsList = creditController.getAllCredits();
        Assert.assertEquals(credits, actualCreditsList);
    }

    @Test
    public void testGetCreditById() {
        when(creditService.getCreditById(CREDIT_ID)).thenReturn(expectedCredit);

        Credit actualCredit = creditController.getCreditById(CREDIT_ID);
        Assert.assertEquals(expectedCredit, actualCredit);
    }

    @Test
    public void testDeleteCreditById() {
        creditController.deleteCreditById(CREDIT_ID);
        verify(creditService).deleteCreditById(CREDIT_ID);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        List<Credit> credits = new ArrayList<>();
        credits.add(expectedCredit);

        when(creditService.getCreditsByCustomerId(CUSTOMER_ID)).thenReturn(credits);

        List<Credit> actualCreditList = creditController.getCreditsByCustomerId(CUSTOMER_ID);
        Assert.assertEquals(credits, actualCreditList);
    }

    @Test
    public void testGetCreditsByProductId() {
        List<Credit> credits = new ArrayList<>();
        credits.add(expectedCredit);

        when(creditService.getCreditsByProductId(PRODUCT_ID)).thenReturn(credits);

        List<Credit> actualCreditList = creditController.getCreditsByProductId(PRODUCT_ID);
        Assert.assertEquals(credits, actualCreditList);
    }
}