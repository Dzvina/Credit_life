package com.matyashdo.credit_ws.dto;

import java.util.Objects;

public class CreditDto {

    private int creditId;

    private int customerId;

    private int productId;

    private String nameCredit;

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameCredit() {
        return nameCredit;
    }

    public void setNameCredit(String nameCredit) {
        this.nameCredit = nameCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditDto)) return false;
        CreditDto creditDto = (CreditDto) o;
        return creditId == creditDto.creditId &&
                customerId == creditDto.customerId &&
                productId == creditDto.productId &&
                nameCredit.equals(creditDto.nameCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, customerId, productId, nameCredit);
    }

    @Override
    public String toString() {
        return "CreditDto{" +
                "creditId=" + creditId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", nameCredit='" + nameCredit + '\'' +
                '}';
    }
}
