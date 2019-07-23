package com.matyashdo.credit_ws.dto;

import java.util.Objects;

public class CreditDetails {

    private CreditDto creditDto;
    private Customer customer;
    private Product product;

    public CreditDto getCreditDto() {
        return creditDto;
    }

    public void setCreditDto(CreditDto creditDto) {
        this.creditDto = creditDto;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditDetails)) return false;
        CreditDetails that = (CreditDetails) o;
        return creditDto.equals(that.creditDto) &&
                customer.equals(that.customer) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditDto, customer, product);
    }

    @Override
    public String toString() {
        return "CreditDetails{" +
                "creditDto=" + creditDto +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
