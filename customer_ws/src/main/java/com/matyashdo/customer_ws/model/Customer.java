package com.matyashdo.customer_ws.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "first_name_customer")
    private String firstNameCustomer;

    @Column(name = "last_name_customer")
    private String lastNameCustomer;

    @Column(name = "pesel_customer")
    private String peselCustomer;

    public Customer() {
    }

    public Customer( String firstNameCustomer, String lastNameCustomer, String peselCustomer) {
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
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                Objects.equals(firstNameCustomer, customer.firstNameCustomer) &&
                Objects.equals(lastNameCustomer, customer.lastNameCustomer) &&
                Objects.equals(peselCustomer, customer.peselCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstNameCustomer, lastNameCustomer, peselCustomer);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstNameCustomer='" + firstNameCustomer + '\'' +
                ", lastNameCustomer='" + lastNameCustomer + '\'' +
                ", peselCustomer='" + peselCustomer + '\'' +
                '}';
    }
}
