package com.matyashdo.customer_ws.dto;

import java.util.Objects;

public class CustomerDto {

    private int customerId;

    private String firstNameCustomer;

    private String lastNameCustomer;

    private String peselCustomer;

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
        CustomerDto that = (CustomerDto) o;
        return customerId == that.customerId &&
                Objects.equals(firstNameCustomer, that.firstNameCustomer) &&
                Objects.equals(lastNameCustomer, that.lastNameCustomer) &&
                Objects.equals(peselCustomer, that.peselCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstNameCustomer, lastNameCustomer, peselCustomer);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", firstNameCustomer='" + firstNameCustomer + '\'' +
                ", lastNameCustomer='" + lastNameCustomer + '\'' +
                ", peselCustomer='" + peselCustomer + '\'' +
                '}';
    }
}
