package com.project.the_banking_app.service.impl;


import com.project.the_banking_app.dto.BankResponse;
import com.project.the_banking_app.dto.CreditDebitRequest;
import com.project.the_banking_app.dto.EnquiryRequest;
import com.project.the_banking_app.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   BankResponse createAccount(UserRequest userRequest);
   BankResponse balanceEnquiry(EnquiryRequest request);
   String nameEnquiry(EnquiryRequest request);
   BankResponse creditAccount(CreditDebitRequest request);
   BankResponse debitAccount(CreditDebitRequest request);


}
