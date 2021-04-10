package com.homestock.homestock.api.request;

import com.homestock.homestock.api.validator.PasswordConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    @PasswordConstraint
    private String password;
}