package com.aggregate.solution.nuban.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 1:24:35 PM
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Banks
{
    private static Map<String, String> map = new HashMap<>();

    static
    {
        map.put("UBA", "033");
        map.put("STERLING BANK", "068");
        map.put("FCMB", "214");
        map.put("ACCESS BANK", "044");
        map.put("ZENITH BANK", "057");
        map.put("WEMA BANK", "035");
        map.put("FIRST BANK", "011");
        map.put("GT BANK", "058");
        map.put("UNITY BANK", "215");
        map.put("STANBIC IBTC BANK", "221");
        map.put("FIDELITY BANK", "070");
    }

    public static List<String> getBankCodes()
    {
        List<String> codes = new ArrayList<>();
        map.entrySet().forEach(c ->
        {
            codes.add(c.getValue());
        });
        return codes;
    }

    public static List<Bank> getBanks()
    {
        List<Bank> codes = new ArrayList<>();
        map.entrySet().forEach(c ->
        {
            codes.add(new Bank(c.getKey(), c.getValue()));
        });
        return codes;
    }
}
