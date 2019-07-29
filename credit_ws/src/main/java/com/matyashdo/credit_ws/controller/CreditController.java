package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
import com.matyashdo.credit_ws.dto.CustomerDto;
import com.matyashdo.credit_ws.dto.ProductDto;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/create")
    public void addCredit(@RequestBody CreditDto creditDto) {
        creditService.addCredit(creditDto);
    }

    @GetMapping
    public List<Credit> getAllCredits() {
        List<Credit> credit = creditService.getAllCredits();
        return credit;
    }

    @GetMapping(value = "/{creditId}")
    public Credit getCreditById(@PathVariable("creditId") int creditId) {
        return creditService.getCreditById(creditId);
    }

    @DeleteMapping(value = "/{creditId}/delete")
    public void deleteCreditById(@PathVariable int creditId) {
        creditService.deleteCreditById(creditId);
    }

    @GetMapping(value = "/{customer_id}/customer")
    public List<Credit> getCreditsByCustomerId(@PathVariable(value = "customer_id") int customerId){
      List<Credit> credits = creditService.getCreditsByCustomerId(customerId);
        return credits;
    }

    @GetMapping(value = "/{product_id}/product")
    public List<Credit> getCreditsByProductId(@PathVariable(value = "product_id") int productId){
        List<Credit> credits = creditService.getCreditsByProductId(productId);
        return credits;
    }
}
