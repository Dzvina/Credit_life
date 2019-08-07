package com.matyashdo.creditDetails_ws.service.impl;

import com.matyashdo.creditDetails_ws.client.RestClient;
import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditService.class);

    @Override
    public void addCredit(CreditDto creditDto) {
        LOGGER.info("Sending create credit request to credit_ws");
        RestClient.createCredit(creditDto);
        LOGGER.info("Credit created successfully");
    }

    @Override
    public CreditDto getCreditById(int creditId) {
        LOGGER.info("Sending get credit by id request to credit_ws");
        CreditDto creditDto = RestClient.getCreditById(creditId);
        LOGGER.info("Received following creditDto in response: {}", creditDto);
        return creditDto;
    }

    @Override
    public void deleteCreditById(int creditId) {
        LOGGER.info("Sending delete credit by id request to credit_ws");
        RestClient.deleteCreditById(creditId);
        LOGGER.info("Credit deleted successfully");
    }

    @Override
    public List<CreditDto> getCreditByCustomerId(int customerId) {
        LOGGER.info("Sending get credit by customer id request to credit_ws");
        List<CreditDto> creditDto = RestClient.getCreditsByCustomerId(customerId);
        LOGGER.info("Received following creditDto in response: {}", creditDto);
        return creditDto;
    }

    @Override
    public List<CreditDto> getCreditByProductId(int productId) {
        LOGGER.info("Sending get credit by product id request to credit_ws");
        List<CreditDto> creditDto = RestClient.getCreditsByProductId(productId);
        LOGGER.info("Received following creditDto in response: {}", creditDto);
        return creditDto;
    }
}