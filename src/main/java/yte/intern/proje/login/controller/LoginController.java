package yte.intern.proje.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.login.service.LoginService;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping()
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {

        return loginService.login(loginRequest);
    }
    @GetMapping
    public String login(){
        return "giriş ekranı";
    }
}
