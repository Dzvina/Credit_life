package com.matyashdo.credit_ws.dto;

import java.util.Objects;

public class Product {

    private String productName;

    private int value;

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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return value == product.value &&
                productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", value=" + value +
                '}';
    }
}
