package com.matyashdo.customer_ws.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    private static final int CUSTOMER_ID = 1;
    private static final String FIRST_NAME_CUSTOMER = "Name";
    private static final String LAST_NAME_CUSTOMER = "Surname";
    private static final String PESEL_CUSTOMER = "12345678901";

    Customer customer = new Customer();

    @Test
    public void getCustomerId() {
        customer.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, customer.getCustomerId());
    }

    @Test
    public void setCustomerId() {
        customer.setCustomerId(CUSTOMER_ID);
        assertEquals(CUSTOMER_ID, customer.getCustomerId());
    }


    @Test
    public void getFirstNameCustomer() {
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        assertEquals(FIRST_NAME_CUSTOMER, customer.getFirstNameCustomer());
    }

    @Test
    public void setFirstNameCustomer() {
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        assertEquals(FIRST_NAME_CUSTOMER, customer.getFirstNameCustomer());
    }

    @Test
    public void getLastNameCustomer() {
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        assertEquals(LAST_NAME_CUSTOMER, customer.getLastNameCustomer());
    }

    @Test
    public void setLastNameCustomer() {
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        assertEquals(LAST_NAME_CUSTOMER, customer.getLastNameCustomer());
    }

    @Test
    public void getPeselCustomer() {
        customer.setPeselCustomer(PESEL_CUSTOMER);
        assertEquals(PESEL_CUSTOMER, customer.getPeselCustomer());
    }

    @Test
    public void setPeselCustomer() {
        customer.setPeselCustomer(PESEL_CUSTOMER);
        assertEquals(PESEL_CUSTOMER, customer.getPeselCustomer());
    }

    @Test
    public void testEquals() {
        customer.setCustomerId(CUSTOMER_ID);
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer.setPeselCustomer(PESEL_CUSTOMER);

        Customer customer1 = new Customer();
        customer1.setCustomerId(CUSTOMER_ID);
        customer1.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer1.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer1.setPeselCustomer(PESEL_CUSTOMER);

        assertTrue(customer.equals(customer1));
    }

    @Test
    public void testHashCode() {
        customer.setCustomerId(CUSTOMER_ID);
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer.setPeselCustomer(PESEL_CUSTOMER);

        Customer customer1 = new Customer();
        customer1.setCustomerId(CUSTOMER_ID);
        customer1.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer1.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer1.setPeselCustomer(PESEL_CUSTOMER);

        assertEquals(customer.hashCode(), customer1.hashCode());
    }

    @Test
    public void testToString() {
        customer.setCustomerId(CUSTOMER_ID);
        customer.setFirstNameCustomer(FIRST_NAME_CUSTOMER);
        customer.setLastNameCustomer(LAST_NAME_CUSTOMER);
        customer.setPeselCustomer(PESEL_CUSTOMER);

        String expectedString = "Customer{customerId=1, firstNameCustomer='Name', lastNameCustomer='Surname', peselCustomer='12345678901'}";
        assertEquals(customer.toString(), expectedString);
    }
}