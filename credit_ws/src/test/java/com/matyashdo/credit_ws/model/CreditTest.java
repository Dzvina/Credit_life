package com.matyashdo.credit_ws.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreditTest {

    private static final int CREDIT_ID = 1;
    private static final String NAME_CREDIT = "credit1";
    Credit credit = new Credit();


    @Test
    public void testGetCreditId() {
        credit.setCreditId(CREDIT_ID);
        assertEquals(CREDIT_ID, credit.getCreditId());
    }

    @Test
    public void testSetCreditId() {
        credit.setCreditId(CREDIT_ID);
        assertEquals(CREDIT_ID, credit.getCreditId());
    }

    @Test
    public void testGetNameCredit() {
        credit.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT, credit.getNameCredit());
    }

    @Test
    public void testSetNameCredit() {
        credit.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT, credit.getNameCredit());
    }

    @Test
    public void testEquals() {
        credit.setCreditId(CREDIT_ID);
        credit.setNameCredit(NAME_CREDIT);

        Credit credit1 = new Credit();
        credit1.setCreditId(CREDIT_ID);
        credit1.setNameCredit(NAME_CREDIT);

        assertTrue(credit.equals(credit1));
    }

    @Test
    public void testHashCode() {
        credit.setCreditId(CREDIT_ID);
        credit.setNameCredit(NAME_CREDIT);

        Credit credit1 = new Credit();
        credit1.setCreditId(CREDIT_ID);
        credit1.setNameCredit(NAME_CREDIT);

        assertEquals(credit.hashCode(), credit1.hashCode());
    }

    @Test
    public void testToString() {
        credit.setCreditId(CREDIT_ID);
        credit.setNameCredit(NAME_CREDIT);

        String expectedString = "CreditDto{creditId=1, nameCredit='credit1'}";
        assertEquals(credit.toString(), expectedString);
    }
}