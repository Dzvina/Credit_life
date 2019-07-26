package com.matyashdo.creditDetails_ws.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductDtoTest {

    private static final int PRODUCT_ID = 1;
    private static final String PRODUCT_NAME = "Product";
    private static final int VALUE = 10;

    ProductDto productDto = new ProductDto();

    @Test
    public void testGetCreditId() {
        productDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID,productDto.getProductId());
    }

    @Test
    public void testSetCreditId() {
        productDto.setProductId(PRODUCT_ID);
        assertEquals(PRODUCT_ID,productDto.getProductId());
    }

    @Test
    public void testGetProductName() {
        productDto.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME,productDto.getProductName());
    }

    @Test
    public void testSetProductName() {
        productDto.setProductName(PRODUCT_NAME);
        assertEquals(PRODUCT_NAME,productDto.getProductName());
    }

    @Test
    public void testGetValue() {
        productDto.setValue(VALUE);
        assertEquals(VALUE,productDto.getValue());
    }

    @Test
    public void testSetValue() {
        productDto.setValue(VALUE);
        assertEquals(VALUE,productDto.getValue());
    }

    @Test
    public void testEquals() {
        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);

        ProductDto productDto1 = new ProductDto();
        productDto1.setProductId(PRODUCT_ID);
        productDto1.setProductName(PRODUCT_NAME);
        productDto1.setValue(VALUE);

        assertTrue(productDto.equals(productDto1));
    }

    @Test
    public void testHashCode() {
        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);

        ProductDto productDto1 = new ProductDto();
        productDto1.setProductId(PRODUCT_ID);
        productDto1.setProductName(PRODUCT_NAME);
        productDto1.setValue(VALUE);

        assertEquals(productDto.hashCode(),productDto1.hashCode());
    }

    @Test
    public void testToString() {
        productDto.setProductId(PRODUCT_ID);
        productDto.setProductName(PRODUCT_NAME);
        productDto.setValue(VALUE);

        String expectedString = "ProductDto{productId=1, productName='Product', value=10}";
        assertEquals(productDto.toString(), expectedString);
    }
}