package yte.intern.proje.login.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import yte.intern.proje.common.response.MessageResponse;
import yte.intern.proje.common.response.ResultType;
import yte.intern.proje.login.controller.LoginRequest;
import yte.intern.proje.login.controller.LoginResponse;
import yte.intern.proje.login.entity.CustomUser;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
@RequiredArgsConstructor
public class LoginService {

    private final AuthenticationManager authenticationManager;

    private final HttpServletResponse response;

    public LoginResponse login(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password());

        Authentication authenticatedAuthentication = authenticationManager.authenticate(token);

        SecurityContext newContext = SecurityContextHolder.createEmptyContext();
        newContext.setAuthentication(authenticatedAuthentication);
        SecurityContextHolder.setContext(newContext);

       // response.addCookie(new Cookie("username",authenticatedAuthentication.getName()));
       // response.addCookie(new Cookie("type",authenticatedAuthentication.getAuthorities().stream().toList().get(0).getAuthority()));
        CustomUser loggedInUser= (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return LoginResponse.fromEntity(loggedInUser);

    }
}