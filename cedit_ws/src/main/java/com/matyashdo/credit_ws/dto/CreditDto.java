package com.matyashdo.credit_ws.dto;

import java.util.Objects;

public class CreditDto {

    private String nameCredit;

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
        return nameCredit.equals(creditDto.nameCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCredit);
    }

    @Override
    public String toString() {
        return "CreditDto{" +
                "nameCredit='" + nameCredit + '\'' +
                '}';
    }
}
