package com.matyashdo.creditDetails_ws.dto;

import java.util.Objects;

public class Credit {

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
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return nameCredit.equals(credit.nameCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCredit);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "nameCredit='" + nameCredit + '\'' +
                '}';
    }
}
