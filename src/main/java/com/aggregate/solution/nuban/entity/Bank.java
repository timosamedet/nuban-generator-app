package com.aggregate.solution.nuban.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 6:01:11 PM
 */
@Data
@NoArgsConstructor
public class Bank
{
    private String bankName;
    private String bankCode;

    public Bank(String bankName, String bankCode)
    {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

}
