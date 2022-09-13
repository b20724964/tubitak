package yte.intern.proje.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public MessageResponse userPage(){
        return new MessageResponse("giriş ekranı", ResultType.SUCCESS);
    }
}
