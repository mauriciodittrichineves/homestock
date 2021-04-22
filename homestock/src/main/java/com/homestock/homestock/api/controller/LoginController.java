package com.homestock.homestock.api.controller;

import com.homestock.homestock.api.request.LoginRequest;
import com.homestock.homestock.api.response.LoginResponse;
import com.homestock.homestock.application.login.DoLoginUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/login")
public class LoginController {
    private DoLoginUseCase doLoginUseCase;
    public LoginController(DoLoginUseCase doLoginUseCase){
        this.doLoginUseCase = doLoginUseCase;
    }
    @PostMapping()
    public LoginResponse doLogin(LoginRequest loginRequest) {
       return this.doLoginUseCase.execute(loginRequest);
    }
}
