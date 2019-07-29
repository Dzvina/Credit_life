package com.matyashdo.creditDetails_ws.controller;

import com.matyashdo.creditDetails_ws.dto.CreditDto;
import com.matyashdo.creditDetails_ws.service.CreditService;
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

    @GetMapping(value = "/{creditId}")
    public CreditDto getCreditById(@PathVariable(value = "creditId") int creditId) {
        return creditService.getCreditById(creditId);
    }

    @DeleteMapping(value = "/{creditId}/delete")
    public void deleteCreditById(@PathVariable(value = "creditId") int creditId) {
        creditService.deleteCreditById(creditId);
    }

    @GetMapping(value = "/{customerId}/customer")
    public List<CreditDto> getCreditsByCustomerId(@PathVariable(value = "customerId") int customerId) {
        return creditService.getCreditByCustomerId(customerId);
    }

    @GetMapping(value = "/{productId}/product")
    public List<CreditDto> getCreditsByProductId(@PathVariable(value = "productId") int productId) {
        return creditService.getCreditByProductId(productId);
    }
}
