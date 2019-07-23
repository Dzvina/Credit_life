package com.matyashdo.credit_ws.controller;

import com.matyashdo.credit_ws.dto.CreditDetails;
import com.matyashdo.credit_ws.model.Credit;
import com.matyashdo.credit_ws.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping(value = "/CreateCredit")
    public int addCredit(@RequestBody CreditDetails creditDetails) {
        return creditService.addCredit(creditDetails);
    }

    @GetMapping(value = "/GetCredits")
    public List<CreditDetails> getAllCredits() {
        List<CreditDetails> creditDetails = creditService.getAllCredits();
        return creditDetails;
    }

    @GetMapping(value = "/GetCredit/credits/{creditId}")
    public CreditDetails getCreditById(@PathVariable("creditId")int creditId) {
        return creditService.getCreditById(creditId);

    }
}
