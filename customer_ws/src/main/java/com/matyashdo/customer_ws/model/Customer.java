package com.matyashdo.customer_ws.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Id
    @Column(name = "credit_id")
    private int creditId;

    @Column(name = "first_name_customer")
    private String firstNameCustomer;

    @Column(name = "last_name_customer")
    private String lastNameCustomer;

    @Column(name = "pesel_customer")
    private String peselCustomer;

    public Customer() {
    }

    public Customer(int creditId, String firstNameCustomer, String lastNameCustomer, String peselCustomer) {
        this.creditId = creditId;
        this.firstNameCustomer = firstNameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.peselCustomer = peselCustomer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public String getFirstNameCustomer() {
        return firstNameCustomer;
    }

    public void setFirstNameCustomer(String firstNameCustomer) {
        this.firstNameCustomer = firstNameCustomer;
    }

    public String getLastNameCustomer() {
        return lastNameCustomer;
    }

    public void setLastNameCustomer(String lastNameCustomer) {
        this.lastNameCustomer = lastNameCustomer;
    }

    public String getPeselCustomer() {
        return peselCustomer;
    }

    public void setPeselCustomer(String peselCustomer) {
        this.peselCustomer = peselCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                creditId == customer.creditId &&
                firstNameCustomer.equals(customer.firstNameCustomer) &&
                lastNameCustomer.equals(customer.lastNameCustomer) &&
                peselCustomer.equals(customer.peselCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, creditId, firstNameCustomer, lastNameCustomer, peselCustomer);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", creditId=" + creditId +
                ", firstNameCustomer='" + firstNameCustomer + '\'' +
                ", lastNameCustomer='" + lastNameCustomer + '\'' +
                ", peselCustomer='" + peselCustomer + '\'' +
                '}';
    }
}
