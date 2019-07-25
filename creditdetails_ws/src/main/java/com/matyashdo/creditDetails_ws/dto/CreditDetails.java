package com.matyashdo.creditDetails_ws.dto;

import java.util.Objects;

public class CreditDetails {

    private Credit credit;
    private Customer customer;
    private Product product;

    public Credit getCredit() {
        return credit;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
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
        return credit.equals(that.credit) &&
                customer.equals(that.customer) &&
                product.equals(that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(credit, customer, product);
    }

    @Override
    public String toString() {
        return "CreditDetails{" +
                "credit=" + credit +
                ", customer=" + customer +
                ", product=" + product +
                '}';
    }
}
