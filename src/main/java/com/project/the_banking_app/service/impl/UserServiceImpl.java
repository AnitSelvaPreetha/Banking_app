package com.project.the_banking_app.service.impl;

import com.project.the_banking_app.dto.AccountInfo;
import com.project.the_banking_app.dto.BankResponse;
import com.project.the_banking_app.dto.UserRequest;
import com.project.the_banking_app.entity.User;
import com.project.the_banking_app.repository.UserRepository;
import com.project.the_banking_app.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {



        //check if user is already has an account

        if(userRepository.existsByEmail(userRequest.getEmail()))
        {
          return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                  .accountInfo(null)
                    .build();

        }

        //Creating a account - saving a new user in db

      User newUser= User.builder()
              .firstName(userRequest.getFirstName())
              .lastName(userRequest.getLastName())
              .otherName(userRequest.getOtherName())
              .gender(userRequest.getGender())
              .address(userRequest.getAddress())
              .stateOfOrigin(userRequest.getStateOfOrigin())
              .accountNumber(AccountUtils.generateAccountNumber())
              .accountBalance(BigDecimal.ZERO)
              .email(userRequest.getEmail())
              .phoneNumber(userRequest.getPhoneNumber())
              .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
              .status("ACTIVE")
              .build();

User savedUser=userRepository.save(newUser);

return BankResponse.builder()
        .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
        .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
        .accountInfo(AccountInfo.builder()
                .accountBalance(savedUser.getAccountBalance())
                .accountNumber(savedUser.getAccountNumber())
                .accountName(savedUser.getFirstName()+" "+savedUser.getLastName()+" "+savedUser.getOtherName())
                .build())
        .build();

    }
}
