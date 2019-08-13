package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

public class CreditControllerTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";
    CreditDto creditDto = new CreditDto();

    @Test
    public void testAddCredit() {
        CreditService creditService = Mockito.mock(CreditService.class);
        Mockito.doNothing().when(creditService).addCredit(any(CreditDto.class));
        CreditController creditController = new CreditController();
        creditController.addCredit(creditDto);
        Mockito.verify(creditService).addCredit(creditDto);
    }

    @Test
    public void testGetAllCredits() {
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