package com.matyashdo.creditDetails_ws.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditDetailsTest {

    CreditDetails creditDetails = new CreditDetails();

    Credit credit = new Credit();
    Customer customer = new Customer();
    Product product = new Product();

    @Test
    public void testGetCreditDto() {
        creditDetails.setCredit(credit);
        assertEquals(credit, creditDetails.getCredit());
    }

    @Test
    public void testSetCreditDto() {
        creditDetails.setCredit(credit);
        assertEquals(credit, creditDetails.getCredit());
    }

    @Test
    public void testGetCustomer() {
        creditDetails.setCustomer(customer);
        assertEquals(customer, creditDetails.getCustomer());
    }

    @Test
    public void testSetCustomer() {
        creditDetails.setCustomer(customer);
        assertEquals(customer, creditDetails.getCustomer());
    }

    @Test
    public void testGetProduct() {
        creditDetails.setProduct(product);
        assertEquals(product, creditDetails.getProduct());
    }

    @Test
    public void testSetProduct() {
        creditDetails.setProduct(product);
        assertEquals(product, creditDetails.getProduct());
    }

    @Test
    public void testEquals() {
        creditDetails.setCredit(credit);
        creditDetails.setCustomer(customer);
        creditDetails.setProduct(product);

        CreditDetails creditDetails1 = new CreditDetails();

        creditDetails1.setCredit(credit);
        creditDetails1.setCustomer(customer);
        creditDetails1.setProduct(product);

        assertTrue(creditDetails.equals(creditDetails1));
    }

    @Test
    public void testHashCode() {
        creditDetails.setCredit(credit);
        creditDetails.setCustomer(customer);
        creditDetails.setProduct(product);

        CreditDetails creditDetails1 = new CreditDetails();

        creditDetails1.setCredit(credit);
        creditDetails1.setCustomer(customer);
        creditDetails1.setProduct(product);

        assertEquals(creditDetails.hashCode(),creditDetails1.hashCode());
    }

    @Test
    public void testToString() {
        creditDetails.setCredit(credit);
        creditDetails.setCustomer(customer);
        creditDetails.setProduct(product);

        String expectedString = "CreditDetails{credit=Credit{nameCredit='null'}, customer=Customer{firstNameCustomer='null', lastNameCustomer='null', peselCustomer='null'}, product=Product{productName='null', value=0}}";
        assertEquals(creditDetails.toString(), expectedString);
    }
}