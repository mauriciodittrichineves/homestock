package com.homestock.homestock.application.login;

import com.homestock.homestock.api.request.LoginRequest;
import com.homestock.homestock.api.response.LoginResponse;

import javax.inject.Named;

@Named
public interface DoLoginUseCase {
    public LoginResponse execute(LoginRequest loginRequest);
}
