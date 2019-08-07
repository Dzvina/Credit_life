package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.dto.CustomerDto;
import com.matyashdo.credit_ws.dto.ProductDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditController.class);

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/create")
    public void addCredit(@RequestBody CreditDto creditDto) {
        LOGGER.info("Received request for credit creation");
        creditService.addCredit(creditDto);
        LOGGER.info("Credit was successfully created");
    }

    @GetMapping
    public List<Credit> getAllCredits() {
        LOGGER.info("Received request for get all credits");
        List<Credit> credit = creditService.getAllCredits();
        LOGGER.info("Credits were successfully fetched: {}", credit);
        return credit;
    }

    @GetMapping(value = "/{creditId}")
    public Credit getCreditById(@PathVariable("creditId") int creditId) {
        LOGGER.info("Received request for get credit by id");
        Credit credit = creditService.getCreditById(creditId);
        LOGGER.info("Credit: {} was successfully fetched", credit);
        return credit;
    }

    @DeleteMapping(value = "/{creditId}/delete")
    public void deleteCreditById(@PathVariable int creditId) {
        LOGGER.info("Received request for credit deletion");
        creditService.deleteCreditById(creditId);
        LOGGER.info("Credit was successfully deleted");
    }

    @GetMapping(value = "/{customer_id}/customer")
    public List<Credit> getCreditsByCustomerId(@PathVariable(value = "customer_id") int customerId) {
        LOGGER.info("Received request for get credits by customer id");
        List<Credit> credits = creditService.getCreditsByCustomerId(customerId);
        LOGGER.info("Credits: {} was successfully fetched", credits);
        return credits;
    }

    @GetMapping(value = "/{product_id}/product")
    public List<Credit> getCreditsByProductId(@PathVariable(value = "product_id") int productId) {
        LOGGER.info("Received request for get credits by product id");
        List<Credit> credits = creditService.getCreditsByProductId(productId);
        LOGGER.info("Credits: {} was successfully fetched", credits);
        return credits;
    }
}
