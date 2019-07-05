package com.matyashdo.product_ws.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "credit_id")
    private int creditId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "value")
    private int value;

    public Product() {
    }

    public Product(int creditId, String productName, int value) {
        this.creditId = creditId;
        this.productName = productName;
        this.value = value;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
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
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return creditId == product.creditId &&
                value == product.value &&
                productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, productName, value);
    }

    @Override
    public String toString() {
        return "Product{" +
                "creditId=" + creditId +
                ", productName='" + productName + '\'' +
                ", value=" + value +
                '}';
    }
}
