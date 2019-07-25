package com.matyashdo.credit_ws.service;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;

import java.util.List;

public interface CreditService {

    void addCredit(CreditDto creditDto);

    List<Credit> getAllCredits();

    Credit getCreditById(int creditId);

    void deleteCreditById(int creditId);
}
