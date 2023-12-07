package com.aggregate.solution.nuban.services;

import com.aggregate.solution.nuban.entity.Nuban;
import com.aggregate.solution.nuban.repository.NubanRepository;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Timosamedet
 * @since Dec 6, 2023 1:26:59 PM
 */
@Service
public class NubanService
{

    @Autowired
    private BankService bankService;

    @Autowired
    private NubanRepository repository;

    private static final int SERIAL_NUMBER_LENGTH = 9;
    private static final int BANK_CODE_LENGTH = 6;

    public int generateCheckDigit(String bankCode, String serialNumber) throws Exception
    {
        /*USING THE CBN ALGORITHM
            STEP 1: Calculate
                    A*3+B*7+C*3+D*3+E*7+F*3+G*3+H*7+I*3+J*3+K*7+L*3+M*3+N*7+O*3
            STEP 2:
                 Calculate Modulo 10 of your result i.e. the remainder after dividing by 10

            STEP 3:
                    Subtract your result from 10 to get the Check Digit
            STEP 4:
                    If your result is 10, then use 0 as your check digit
         */
        if(bankCode.length() > 3)
            throw new Exception("Bank Code must not exeeds three(3) digits");
        if(serialNumber.length() > SERIAL_NUMBER_LENGTH)
            throw new Exception("Serial Nuber  must not exeeds nine(9) digits");

        serialNumber = padZeros(serialNumber, SERIAL_NUMBER_LENGTH);
        bankCode = padZeros(bankCode, BANK_CODE_LENGTH);

        var salt = bankCode.concat(serialNumber);
        String[] saltArray = salt.split("");
        int mulSevenIndex = 1;
        int sum = 0;
        int checkDigit;
        for(int i = 0; i < saltArray.length; i++)
        {
            if(i == mulSevenIndex)
            {
                sum += Integer.parseInt(saltArray[i]) * 7;
                mulSevenIndex += 3; //After the second digit, every multiple of seven occurs in three(3) count.
                continue;
            }
            sum += Integer.parseInt(saltArray[i]) * 3;
        }
        sum %= 10;
        checkDigit = 10 - sum;
        return checkDigit == 10 ? 0 : checkDigit;
    }

    public static String generateSerialNumber()
    {
        return new DecimalFormat("000000000")
                .format(new Random().nextInt(999999999));
    }

    public String generateNuban(String bankCode, String serialNumber) throws Exception
    {
        serialNumber = padZeros(serialNumber, SERIAL_NUMBER_LENGTH);
        return serialNumber.concat(String.valueOf(generateCheckDigit(bankCode, serialNumber)));
    }

    public String padZeros(String value, int length)
    {
        if(value.length() == length)
            return value;
        else
        {
            StringBuilder zerosPad = new StringBuilder();
            while(zerosPad.length() < length - value.length())
                zerosPad.append("0");
            zerosPad.append(value);
            return zerosPad.toString();
        }

    }

    public Nuban createNuban(String bankCode, String serialNumber)
    {
        Nuban nuban = new Nuban();
        nuban.setBankCode(bankCode);
        nuban.setSerialNumber(serialNumber);

        bankService.getBanks().forEach(b ->
        {
            if(b.getBankCode().equals(bankCode))
                nuban.setBankName(b.getBankName());
        });

        try
        {
            nuban.setCheckDigit(generateCheckDigit(bankCode, serialNumber));
            nuban.setNubanGenerated(generateNuban(bankCode, serialNumber));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return repository.save(nuban);
    }

    public List<Nuban> getAllNubans()
    {
        return repository.findAll();
    }
}
