package com.matyashdo.credit_ws.dao;

import com.matyashdo.credit_ws.model.Credit;

import java.util.List;

public interface CreditDao {

    void addCredit(Credit credit);

    List<Credit> getAllCredits();

    Credit getCreditById(int creditId);

    void deleteCreditById(int creditId);

    List<Credit> getCreditsByCustomerId(int customerId);

    List<Credit> getCreditsByProductId(int productId);
}
