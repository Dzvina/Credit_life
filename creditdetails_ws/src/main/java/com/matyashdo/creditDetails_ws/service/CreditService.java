package com.matyashdo.creditDetails_ws.service;

import com.matyashdo.creditDetails_ws.dto.CreditDto;

import java.util.List;

public interface CreditService {

    void addCredit(CreditDto creditDto);

    CreditDto getCreditById(int creditId);

    void deleteCreditById(int creditId);

    List<CreditDto> getCreditByCustomerId(int customerId);

    List<CreditDto> getCreditByProductId(int productId);

    List<CreditDto> getAllCredits();
}
