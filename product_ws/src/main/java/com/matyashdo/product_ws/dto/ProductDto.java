package com.matyashdo.product_ws.dto;

import java.util.Objects;

public class ProductDto {

    private int productId;

    private String productName;

    private int value;



    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDto)) return false;
        ProductDto that = (ProductDto) o;
        return productId == that.productId &&
                value == that.value &&
                productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, value);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                '}';
    }
}
