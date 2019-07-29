package com.matyashdo.credit_ws.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerDtoTest {

    private static final int CUSTOMER_ID = 1;
    CustomerDto customerDto = new CustomerDto();

    @Test
    public void testGetCustomerId() {
        customerDto.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, customerDto.getCustomerId());
    }

    @Test
    public void testSetCustomerId() {
        customerDto.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, customerDto.getCustomerId());
    }

    @Test
    public void testEquals() {
        customerDto.setCustomerId(CUSTOMER_ID);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setCustomerId(CUSTOMER_ID);

        assertTrue(customerDto.equals(customerDto1));
    }

    @Test
    public void testHashCode() {
        customerDto.setCustomerId(CUSTOMER_ID);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setCustomerId(CUSTOMER_ID);

        assertEquals(customerDto.hashCode(), customerDto1.hashCode());
    }

    @Test
    public void testToString() {
        customerDto.setCustomerId(CUSTOMER_ID);

        String expectedString = "CustomerDto{customerId=1}";
        assertEquals(customerDto.toString(), expectedString);
    }
}