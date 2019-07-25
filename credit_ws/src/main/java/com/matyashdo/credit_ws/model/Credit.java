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

    @Column(name ="customer_id")
    private int customerId;

    @Column(name="product_id")
    private int productId;

    @Column(name = "name_credit")
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
        if (!(o instanceof Credit)) return false;
        Credit credit = (Credit) o;
        return creditId == credit.creditId &&
                customerId == credit.customerId &&
                productId == credit.productId &&
                nameCredit.equals(credit.nameCredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(creditId, customerId, productId, nameCredit);
    }

    @Override
    public String toString() {
        return "Credit{" +
                "creditId=" + creditId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", nameCredit='" + nameCredit + '\'' +
                '}';
    }
}
