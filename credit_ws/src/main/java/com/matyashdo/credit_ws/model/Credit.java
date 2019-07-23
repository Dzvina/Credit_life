package com.matyashdo.credit_ws.model;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "credit_id")
    private int creditId;

    @Column(name = "name_credit")
    private String nameCredit;

    public int getCreditId() {
        return creditId;
    }

    public void setCreditId(int creditId) {
        this.creditId = creditId;
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
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return creditId == credit.creditId &&
                nameCredit.equals(credit.nameCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, nameCredit);
    }

    @Override
    public String toString() {
        return "CreditDto{" +
                "creditId=" + creditId +
                ", nameCredit='" + nameCredit + '\'' +
                '}';
    }
}
