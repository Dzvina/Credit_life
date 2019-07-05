package com.matyashdo.credit_ws.dao;

import com.matyashdo.credit_ws.model.Credit;

import java.util.List;

public interface CreditDao {

    int addCredit(Credit credit);

    List<Credit> getAllCredits();
}
