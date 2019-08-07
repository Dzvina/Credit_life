package com.matyashdo.credit_ws.service.impl;

import com.matyashdo.credit_ws.dao.CreditDao;
import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditService.class);

    @Autowired
    private CreditDao creditDao;

    @Override
    public void addCredit(CreditDto creditDto) {
        LOGGER.info("Creating credit from creditDto: {}", creditDto);
        Credit credit = new Credit();
        credit.setCustomerId(creditDto.getCustomerId());
        credit.setProductId(creditDto.getProductId());
        credit.setNameCredit(creditDto.getNameCredit());
        LOGGER.info("Credit creation: {}", credit);
        LOGGER.info("Calling dao to insert credit");
        creditDao.addCredit(credit);
        LOGGER.info("Dao successfully inserted credit");
    }

    @Override
    public List<Credit> getAllCredits() {
        LOGGER.info("Calling dao to get all credits");
        List<Credit> credits = creditDao.getAllCredits();
        LOGGER.info("Dao successfully got credits");
        return credits;
    }

    @Override
    public Credit getCreditById(int creditId) {
        LOGGER.info("Calling dao to get credit by id: {}", creditId);
        Credit credit = creditDao.getCreditById(creditId);
        LOGGER.info("Dao successfully got credit by credit id: {}", credit);
        return credit;
    }

    @Override
    public void deleteCreditById(int creditId) {
        LOGGER.info("Calling dao to delete credit by id: {}", creditId);
        creditDao.deleteCreditById(creditId);
        LOGGER.info("Dao successfully deleted credit");
    }

    @Override
    public List<Credit> getCreditsByCustomerId(int customerId) {
        LOGGER.info("Calling dao to get credit by customer id: {}", customerId);
        List<Credit> credits = creditDao.getCreditsByCustomerId(customerId);
        LOGGER.info("Dao successfully got credits by customer id: {}", credits);
        return credits;
    }

    @Override
    public List<Credit> getCreditsByProductId(int productId) {
        LOGGER.info("Calling dao to get credit by product id: {}", productId);
        List<Credit> credits = creditDao.getCreditsByProductId(productId);
        LOGGER.info("Dao successfully got credits by productId id: {}", credits);
        return credits;
    }
}
