package com.matyashdo.product_ws.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    private static final int CREDIT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    Product product = new Product();

    @Test
    public void testGetCreditId() {
       product.setProductId(CREDIT_ID);
       assertEquals(CREDIT_ID,product.getProductId());
    }

    @Test
    public void testSetCreditId() {
        product.setProductId(CREDIT_ID);
        assertEquals(CREDIT_ID,product.getProductId());
    }

    @Test
    public void testGetProductName() {
        product.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME,product.getProductName());
    }

    @Test
    public void testSetProductName() {
        product.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME,product.getProductName());
    }

    @Test
    public void testGetValue() {
        product.setValue(VALUE);
        assertEquals(VALUE,product.getValue());
    }

    @Test
    public void testSetValue() {
        product.setValue(VALUE);
        assertEquals(VALUE,product.getValue());
    }

    @Test
    public void testEquals() {
        product.setProductId(CREDIT_ID);
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        Product product1 = new Product();
        product1.setProductId(CREDIT_ID);
        product1.setProductName(PRODUCT_NAME);
        product1.setValue(VALUE);

        assertTrue(product.equals(product1));
    }

    @Test
    public void testHashCode() {
        product.setProductId(CREDIT_ID);
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        Product product1 = new Product();
        product1.setProductId(CREDIT_ID);
        product1.setProductName(PRODUCT_NAME);
        product1.setValue(VALUE);

        assertEquals(product.hashCode(),product1.hashCode());
    }

    @Test
    public void testToString() {
        product.setProductId(CREDIT_ID);
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        String expectedString = "Product{creditId=1, productName='Product', value=10}";
        assertEquals(product.toString(), expectedString);
    }
}