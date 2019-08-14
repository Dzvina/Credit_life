package com.matyashdo.credit_ws.service.impl;

import com.matyashdo.credit_ws.controller.CreditController;
import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.dao.impl.CreditDaoImpl;
import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class CreditServiceImplTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";
    CreditDto creditDto = new CreditDto();
    Credit credit = new Credit();

    @Mock
    private CreditDao creditDao;

    @InjectMocks
    private CreditServiceImpl creditServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCredit() {
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

        doNothing().when(creditDao).addCredit(any(Credit.class));
        creditServiceImpl.addCredit(creditDto);
        verify(creditDao).addCredit(credit);
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