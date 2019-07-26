package com.matyashdo.credit_ws.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditDtoTest {

    private static final int CREDIT_ID = 1;
    private static final int CUSTOMER_ID = 1;
    private static final int PRODUCT_ID = 1;
    private static final String NAME_CREDIT = "credit1";
    CreditDto creditDto = new CreditDto();

    @Test
    public void testGetCreditId() {
        creditDto.setCreditId(CREDIT_ID);
        assertEquals(CREDIT_ID, creditDto.getCreditId());
    }

    @Test
    public void testSetCreditId() {
        creditDto.setCreditId(CREDIT_ID);
        assertEquals(CREDIT_ID, creditDto.getCreditId());
    }

    @Test
    public void testGetCustomerId() {
        creditDto.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, creditDto.getCustomerId());
    }

    @Test
    public void testSetCustomerId() {
        creditDto.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, creditDto.getCustomerId());
    }

    @Test
    public void testGetProductId() {
        creditDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID, creditDto.getProductId());
    }

    @Test
    public void testSetProductId() {
        creditDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID, creditDto.getProductId());
    }

    @Test
    public void testGetNameCredit() {
        creditDto.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT, creditDto.getNameCredit());
    }

    @Test
    public void testSetNameCredit() {
        creditDto.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT, creditDto.getNameCredit());
    }

    @Test
    public void testEquals() {
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

        CreditDto creditDto1 = new CreditDto();
        creditDto1.setCreditId(CREDIT_ID);
        creditDto1.setCustomerId(CUSTOMER_ID);
        creditDto1.setProductId(PRODUCT_ID);
        creditDto1.setNameCredit(NAME_CREDIT);

        assertTrue(creditDto.equals(creditDto1));
    }

    @Test
    public void testHashCode() {
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

        CreditDto creditDto1 = new CreditDto();
        creditDto1.setCreditId(CREDIT_ID);
        creditDto1.setCustomerId(CUSTOMER_ID);
        creditDto1.setProductId(PRODUCT_ID);
        creditDto1.setNameCredit(NAME_CREDIT);

        assertEquals(creditDto.hashCode(), creditDto1.hashCode());
    }

    @Test
    public void testToString() {
        creditDto.setCreditId(CREDIT_ID);
        creditDto.setCustomerId(CUSTOMER_ID);
        creditDto.setProductId(PRODUCT_ID);
        creditDto.setNameCredit(NAME_CREDIT);

        String expectedString = "CreditDto{creditId=1, customerId=1, productId=1, nameCredit='credit1'}";
        assertEquals(creditDto.toString(), expectedString);
    }
}