package com.matyashdo.credit_ws.service.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.dto.CustomerDto;
import com.matyashdo.credit_ws.dto.ProductDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDao creditDao;

    @Override
    public void addCredit(CreditDto creditDto) {
        Credit credit = new Credit();
        credit.setCustomerId(creditDto.getCustomerId());
        credit.setProductId(creditDto.getProductId());
        credit.setNameCredit(creditDto.getNameCredit());
        creditDao.addCredit(credit);
    }

    @Override
    public List<Credit> getAllCredits() {
        List<Credit> credits = creditDao.getAllCredits();
        return credits;
    }

    @Override
    public Credit getCreditById(int creditId) {
        Credit credit = creditDao.getCreditById(creditId);
        return credit;
    }

    @Override
    public void deleteCreditById(int creditId) {
        creditDao.deleteCreditById(creditId);
    }

    @Override
    public List<Credit> getCreditsByCustomerId(int customerId) {
        List<Credit> credits = creditDao.getCreditsByCustomerId(customerId);
        return credits;
    }

    @Override
    public List<Credit> getCreditsByProductId(int productId) {
        List<Credit> credits = creditDao.getCreditsByProductId(productId);
        return credits;
    }
}
