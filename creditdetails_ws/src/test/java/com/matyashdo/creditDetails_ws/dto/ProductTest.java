package com.matyashdo.creditDetails_ws.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductTest {

    private static final String PRODUCT_NAME = "Name1";
    private static final int VALUE = 10;
    Product product = new Product();

    @Test
    public void testGetProductName() {
        product.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME, product.getProductName());
    }

    @Test
    public void testSetProductName() {
        product.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME, product.getProductName());
    }

    @Test
    public void testGetValue() {
        product.setValue(VALUE);
        assertEquals(VALUE, product.getValue());
    }

    @Test
    public void testSetValue() {
        product.setValue(VALUE);
        assertEquals(VALUE, product.getValue());
    }

    @Test
    public void testEquals() {
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        Product product1 = new Product();
        product1.setProductName(PRODUCT_NAME);
        product1.setValue(VALUE);

        assertTrue(product.equals(product1));
    }

    @Test
    public void testHashCode() {
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        Product product1 = new Product();
        product1.setProductName(PRODUCT_NAME);
        product1.setValue(VALUE);

        assertEquals(product.hashCode(),product1.hashCode());
    }

    @Test
    public void testToString() {
        product.setProductName(PRODUCT_NAME);
        product.setValue(VALUE);

        String expectedString = "Product{productName='Name1', value=10}";
        assertEquals(product.toString(), expectedString);
    }
}