package yte.intern.proje.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.login.service.LoginService;


import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public String login(@RequestBody @Valid LoginRequest loginRequest) {

        return loginService.login(loginRequest);
    }
    @GetMapping
    public String login(){
        return "giriş ekranı";
    }
}
