package com.project.the_banking_app.service.impl;


import com.project.the_banking_app.dto.BankResponse;
import com.project.the_banking_app.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

   BankResponse createAccount(UserRequest userRequest);


}
