package yte.intern.proje.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/logout", method = RequestMethod.GET)
@RequiredArgsConstructor
public class LogoutController {



    @GetMapping()
    public String logout() {

        return "çıkmışızdır umarım";
    }

}

