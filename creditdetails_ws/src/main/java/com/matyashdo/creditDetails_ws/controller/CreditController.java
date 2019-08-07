package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.service.CreditService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {

    private  static final Logger LOGGER = LoggerFactory.getLogger(CreditController.class);

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/create")
    public void addCredit(@RequestBody CreditDto creditDto) {
        LOGGER.info("Received request for credit creation");
        creditService.addCredit(creditDto);
        LOGGER.info("Credit was successfully created");
    }

    @GetMapping(value = "/{creditId}")
    public CreditDto getCreditById(@PathVariable(value = "creditId") int creditId) {
        LOGGER.info("Received request for get credit by id");
        CreditDto creditDto = creditService.getCreditById(creditId);
        LOGGER.info("Credit: {} was successfully fetched", creditDto);
        return creditDto;

    }

    @DeleteMapping(value = "/{creditId}/delete")
    public void deleteCreditById(@PathVariable(value = "creditId") int creditId) {
        LOGGER.info("Received request for credit deletion");
        creditService.deleteCreditById(creditId);
        LOGGER.info("Credit was successfully deleted");
    }

    @GetMapping(value = "/{customerId}/customer")
    public List<CreditDto> getCreditsByCustomerId(@PathVariable(value = "customerId") int customerId) {
        LOGGER.info("Received request for get credits by customer id");
        List<CreditDto> creditDto = creditService.getCreditByCustomerId(customerId);
        LOGGER.info("Credits: {} was successfully fetched", creditDto);
        return creditDto;
    }

    @GetMapping(value = "/{productId}/product")
    public List<CreditDto> getCreditsByProductId(@PathVariable(value = "productId") int productId) {
        LOGGER.info("Received request for get credits by product id");
        List<CreditDto> creditDto = creditService.getCreditByProductId(productId);
        LOGGER.info("Credits: {} was successfully fetched", creditDto);
        return creditDto;
    }
}
