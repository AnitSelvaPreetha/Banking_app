package com.project.the_banking_app.utils;

import java.time.Year;

public class AccountUtils {

public static final String ACCOUNT_EXISTS_CODE="001";
public static final String ACCOUNT_EXISTS_MESSAGE="This User already has an account";
 public static final String  ACCOUNT_CREATION_SUCCESS="002";
 public static final String ACCOUNT_CREATION_MESSAGE="Account created successfully created!";




    // Year + Random six digits
    public static String generateAccountNumber()
    {
        Year currentYear=Year.now();

        int min=100000;
        int max=999999;

        //generate a random number between min and max

        int randomNumber=(int)Math.floor(Math.random() * (max-min+1)+ min);

        //convert to string

        String year=String.valueOf(currentYear);
        String random = String.valueOf(randomNumber);

        StringBuilder accountNumber=new StringBuilder();

       return accountNumber.append(year).append(random).toString();
    }



}
