package com.homestock.homestock.application.login.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.homestock.homestock.api.request.LoginRequest;
import com.homestock.homestock.api.response.LoginResponse;
import com.homestock.homestock.application.login.DoLoginUseCase;
import com.homestock.homestock.entitites.User;
import com.homestock.homestock.exception.UnauthorizedException;
import com.homestock.homestock.repository.UserRepository;
public class DoLoginUseCaseImpl implements DoLoginUseCase {
    private UserRepository userRepository;
    public DoLoginUseCaseImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public LoginResponse execute(LoginRequest loginRequest) {
        var optionalUser = this.userRepository.findByEmail(loginRequest.getEmail());
        if (optionalUser.isPresent()){
            var user = optionalUser.get();
            checkIfPasswordMatch(user.getPassword(), loginRequest.getPassword());
            var token = generateToken(user);
            return new LoginResponse(token);
        } else {
            throw new UnauthorizedException("Email or password invalid");
        }
    }

    private String generateToken(User user) {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            return JWT.create()
                    .withIssuer(user.getEmail())
                    .sign(algorithm);
    }

    private void checkIfPasswordMatch(String userPassword, String passwordRequest) {
        if (!passwordRequest.equals(userPassword)) {
            throw new UnauthorizedException("Email or password invalid");
        }
    }
}
