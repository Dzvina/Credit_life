package com.matyashdo.creditDetails_ws.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreditTest {

    private static final String NAME_CREDIT = "credit1";
    Credit credit = new Credit();

    @Test
    public void testGetNameCredit() {
        credit.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT,credit.getNameCredit());
    }

    @Test
    public void testSetNameCredit() {
        credit.setNameCredit(NAME_CREDIT);
        assertEquals(NAME_CREDIT,credit.getNameCredit());
    }

    @Test
    public void testEquals() {
        credit.setNameCredit(NAME_CREDIT);

        Credit credit1 = new Credit();
        credit1.setNameCredit(NAME_CREDIT);

        assertTrue(credit.equals(credit1));
    }

    @Test
    public void testHashCode() {
        credit.setNameCredit(NAME_CREDIT);

        Credit credit1 = new Credit();
        credit1.setNameCredit(NAME_CREDIT);

        assertEquals(credit.hashCode(),credit1.hashCode());
    }

    @Test
    public void testToString() {
        credit.setNameCredit(NAME_CREDIT);

        String expectedString = "Credit{creditId=0, nameCredit='credit1'}";
        assertEquals(credit.toString(),expectedString);
    }
}