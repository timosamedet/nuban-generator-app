package com.aggregate.solution.nuban.controller;

import com.aggregate.solution.nuban.entity.Nuban;
import com.aggregate.solution.nuban.services.NubanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 1:29:59 PM
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
public class NubanController
{

    @Autowired
    private NubanService nubanService;

    @RequestMapping("/serial-number")
    public String getSerialNumber()
    {
        return NubanService.generateSerialNumber();
    }

    @PostMapping("/create-nuban")
    public Nuban createNuban(@RequestParam("bankCode") String bankCode, @RequestParam("serialNumber") String serialNumber)
    {
        return nubanService.createNuban(bankCode, serialNumber);
    }

    @GetMapping("/nuban-list")
    public List<Nuban> getAllNubans()
    {
        return nubanService.getAllNubans();
    }

    @RequestMapping("/generated-check-digit")
    public Integer getCheckDigit(@RequestParam("bankCode") String bankCode, @RequestParam("serialNumber") String serialNumber) throws Exception
    {
        return nubanService.generateCheckDigit(bankCode, serialNumber);
    }

}
