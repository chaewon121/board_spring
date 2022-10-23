package com.example.board.controller;

import com.example.board.domain.Account;
import com.example.board.domain.AccountDto;
import com.example.board.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder; //비밀번호 암호화


    @GetMapping("/users")
    public String createUser(){
        return "articles/login/register";
    }
    //ModelMapper 란 서로 다른 object 간의 필드 값을 자동으로 mapping 해주는 library
    @PostMapping("/users")
    public String createUser(AccountDto accountDto){
        log.info("뭔가 출력될거임");
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);
        log.info(account.toString());

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        userService.createUser(account);


        return "redirect:/articles";
    }
}
