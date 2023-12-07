package com.aggregate.solution.nuban.controller;

import com.aggregate.solution.nuban.entity.Bank;
import com.aggregate.solution.nuban.services.BankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 6:23:55 PM
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins =
{
    "http://localhost:4200"
}, methods =
{
    RequestMethod.OPTIONS, RequestMethod.GET, RequestMethod.POST
})
public class BankController
{

    @Autowired
    private BankService bankService;

    @RequestMapping("/bank-codes")
    public List<String> getBankCodes()
    {
        return bankService.getBankCodes();

    }

    @RequestMapping("/banks")
    public List<Bank> getBanks()
    {
        return bankService.getBanks();

    }
}
