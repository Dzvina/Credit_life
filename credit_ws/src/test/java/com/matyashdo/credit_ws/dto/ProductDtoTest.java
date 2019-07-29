package com.matyashdo.credit_ws.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDtoTest {

    private static final int PRODUCT_ID = 1;
    ProductDto productDto = new ProductDto();

    @Test
    public void testGetProductId() {
        productDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID, productDto.getProductId());
    }

    @Test
    public void testSetProductId() {
        productDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID, productDto.getProductId());
    }

    @Test
    public void testEquals() {
        productDto.setProductId(PRODUCT_ID);

        ProductDto productDto1 = new ProductDto();
        productDto1.setProductId(PRODUCT_ID);

        assertTrue(productDto.equals(productDto1));
    }

    @Test
    public void testHashCode() {
        productDto.setProductId(PRODUCT_ID);

        ProductDto productDto1 = new ProductDto();
        productDto1.setProductId(PRODUCT_ID);

        assertEquals(productDto.hashCode(), productDto1.hashCode());
    }

    @Test
    public void testToString() {
        productDto.setProductId(PRODUCT_ID);

        String expectedString = "ProductDto{productId=1}";
        assertEquals(productDto.toString(), expectedString);
    }
}