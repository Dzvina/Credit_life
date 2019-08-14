package com.matyashdo.credit_ws.service.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
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
    private Credit credit = new Credit();

    @Mock
    private CreditDao creditDao;

    @InjectMocks
    private CreditServiceImpl creditServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

        credit.setCustomerId(CUSTOMER_ID);
        credit.setProductId(PRODUCT_ID);
        credit.setNameCredit(NAME_CREDIT);
    }

    @Test
    public void testAddCredit() {
        creditServiceImpl.addCredit(creditDto);
        verify(creditDao).addCredit(credit);
    }

    @Test
    public void testGetAllCredits() {
        List<Credit> expectedCreditList = new ArrayList<>();

        when(creditDao.getAllCredits()).thenReturn(expectedCreditList);

        List<Credit> actualCreditList = creditServiceImpl.getAllCredits();
        Assert.assertEquals(expectedCreditList, actualCreditList);
    }

    @Test
    public void testGetCreditById() {
        when(creditDao.getCreditById(CREDIT_ID)).thenReturn(credit);

        Credit actualCredit = creditServiceImpl.getCreditById(CREDIT_ID);

        Assert.assertEquals(credit, actualCredit);
    }

    @Test
    public void testDeleteCreditById() {
        creditServiceImpl.deleteCreditById(CREDIT_ID);
        verify(creditDao).deleteCreditById(CREDIT_ID);
    }

    @Test
    public void testGetCreditsByCustomerId() {
        List<Credit> credits = new ArrayList<>();
        credits.add(credit);

        when(creditDao.getCreditsByCustomerId(CUSTOMER_ID)).thenReturn(credits);

        List<Credit> actualCreditList = creditServiceImpl.getCreditsByCustomerId(CUSTOMER_ID);
        Assert.assertEquals(credits, actualCreditList);
    }

    @Test
    public void testGetCreditsByProductId() {
        List<Credit> credits = new ArrayList<>();
        credits.add(credit);

        when(creditDao.getCreditsByProductId(PRODUCT_ID)).thenReturn(credits);

        List<Credit> actualCreditList = creditServiceImpl.getCreditsByProductId(PRODUCT_ID);
        Assert.assertEquals(credits, actualCreditList);
    }
}