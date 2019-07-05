package com.matyashdo.credit_ws.service.impl;

import com.matyashdo.credit_ws.client.RestClient;
import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.dto.CreditDetails;
import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.dto.Customer;
import com.matyashdo.credit_ws.dto.Product;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditDao creditDao;

    @Override
    public int addCredit(CreditDetails creditDetails) {
        Credit credit = new Credit();
        credit.setNameCredit(creditDetails.getCreditDto().getNameCredit());
        int creditId = creditDao.addCredit(credit);

        Customer customer = creditDetails.getCustomer();
        RestClient.createCustomer(creditId, customer.getFirstNameCustomer(), customer.getLastNameCustomer(), customer.getPeselCustomer());

        Product product = creditDetails.getProduct();
        RestClient.createProduct(creditId, product.getProductName(), product.getValue());

        return creditId;
    }

    @Override
    public List<CreditDetails> getAllCredits() {
        List<Credit> credits = creditDao.getAllCredits();
        List<CreditDetails> creditDetailsList = new ArrayList<>();
        for (Credit credit : credits) {
            CreditDetails creditDetails = new CreditDetails();

            CreditDto creditDto = new CreditDto();
            creditDto.setNameCredit(credit.getNameCredit());

            Customer customer = RestClient.getCustomer(credit.getCreditId());
            Product product = RestClient.getProduct(credit.getCreditId());

            creditDetails.setCreditDto(creditDto);
            creditDetails.setCustomer(customer);
            creditDetails.setProduct(product);
            creditDetailsList.add(creditDetails);
        }
        return creditDetailsList;
    }
}
