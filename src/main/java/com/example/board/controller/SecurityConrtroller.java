package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class SecurityConrtroller {
    @GetMapping("/articles/mypage")
    public String mypage() {
        return "articles/mypage";
    }
    @GetMapping("/articles/admin")
    public String admin() {
        return "articles/admin";
    }
    @GetMapping("/articles/manager")
    public String manager() {
        return "articles/manager";
    }



}
