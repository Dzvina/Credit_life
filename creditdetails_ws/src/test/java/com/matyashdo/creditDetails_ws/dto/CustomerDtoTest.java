package com.matyashdo.creditDetails_ws.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerDtoTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

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
    public void testGetFirstNameCustomer() {
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        assertEquals(FIRST_NAME_CUSTOMER, customerDto.getFirstNameCustomer());
    }

    @Test
    public void testSetFirstNameCustomer() {
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        assertEquals(FIRST_NAME_CUSTOMER, customerDto.getFirstNameCustomer());
    }

    @Test
    public void testGetLastNameCustomer() {
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        assertEquals(LAST_NAME_CUSTOMER, customerDto.getLastNameCustomer());
    }

    @Test
    public void testSetLastNameCustomer() {
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        assertEquals(LAST_NAME_CUSTOMER, customerDto.getLastNameCustomer());
    }

    @Test
    public void testGetPeselCustomer() {
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
        assertEquals(PESEL_CUSTOMER, customerDto.getPeselCustomer());
    }

    @Test
    public void testSetPeselCustomer() {
        customerDto.setPeselCustomer(PESEL_CUSTOMER);
        assertEquals(PESEL_CUSTOMER, customerDto.getPeselCustomer());
    }

    @Test
    public void testEquals() {
        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setCustomerId(CUSTOMER_ID);
        customerDto1.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto1.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto1.setPeselCustomer(PESEL_CUSTOMER);

        assertTrue(customerDto.equals(customerDto1));
    }

    @Test
    public void testHashCode() {
        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);

        CustomerDto customerDto1 = new CustomerDto();
        customerDto1.setCustomerId(CUSTOMER_ID);
        customerDto1.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto1.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto1.setPeselCustomer(PESEL_CUSTOMER);

        assertEquals(customerDto.hashCode(), customerDto1.hashCode());
    }

    @Test
    public void testToString() {
        customerDto.setCustomerId(CUSTOMER_ID);
        customerDto.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customerDto.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customerDto.setPeselCustomer(PESEL_CUSTOMER);

        String expectedString = "CustomerDto{customerId=1, firstNameCustomer='Name', lastNameCustomer='Surname', peselCustomer='12345678901'}";
        assertEquals(customerDto.toString(), expectedString);
    }
}