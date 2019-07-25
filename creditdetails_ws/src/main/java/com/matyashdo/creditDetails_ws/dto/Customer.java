package com.matyashdo.creditDetails_ws.dto;

import java.util.Objects;


public class Customer {

    private String firstNameCustomer;

    private String lastNameCustomer;

    private String peselCustomer;

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

    public Customer() {
    }

    public Customer(String firstNameCustomer, String lastNameCustomer, String peselCustomer) {
        this.firstNameCustomer = firstNameCustomer;
        this.lastNameCustomer = lastNameCustomer;
        this.peselCustomer = peselCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return firstNameCustomer.equals(customer.firstNameCustomer) &&
                lastNameCustomer.equals(customer.lastNameCustomer) &&
                peselCustomer.equals(customer.peselCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNameCustomer, lastNameCustomer, peselCustomer);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstNameCustomer='" + firstNameCustomer + '\'' +
                ", lastNameCustomer='" + lastNameCustomer + '\'' +
                ", peselCustomer='" + peselCustomer + '\'' +
                '}';
    }
}
