package com.matyashdo.credit_ws.service;

import com.matyashdo.credit_ws.dto.CreditDetails;
import com.matyashdo.credit_ws.model.Credit;

import java.util.List;

public interface CreditService {

    int addCredit(CreditDetails creditDetails);

    List<CreditDetails> getAllCredits();
}
