package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDto;
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
}
