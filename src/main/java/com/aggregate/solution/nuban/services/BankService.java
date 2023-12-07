package com.aggregate.solution.nuban.services;

import com.aggregate.solution.nuban.entity.Bank;
import com.aggregate.solution.nuban.entity.Banks;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 6:05:31 PM
 */
@Service
public class BankService
{

    public List<Bank> getBanks()
    {
        return Banks.getBanks();
    }

    public List<String> getBankCodes()
    {
        return Banks.getBankCodes();
    }
}
