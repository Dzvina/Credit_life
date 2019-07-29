package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.service.CreditService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Override
    public void addCredit(CreditDto creditDto) {
        RestClient.createCredit(creditDto);
    }

    @Override
    public CreditDto getCreditById(int creditId) {
        return RestClient.getCreditById(creditId);
    }

    @Override
    public void deleteCreditById(int creditId) {
        RestClient.deleteCreditById(creditId);
    }

    @Override
    public List<CreditDto> getCreditByCustomerId(int customerId) {
        return RestClient.getCreditsByCustomerId(customerId);
    }

    @Override
    public List<CreditDto> getCreditByProductId(int productId) {
        return RestClient.getCreditsByProductId(productId);
    }
}
