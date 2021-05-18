package com.homestock.homestock.entitites;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    String name;
    String email;
    String cpf;
    String password;

    @BeforeEach
    public void setup(){
        this.name ="UserTest";
        this.email = "emailtest";
        this.cpf = "32694878865";
        this.password = "1234Teste";
    }
    @Test
    public void whenToCreateANewUser(){

        User newUser =  new User(name,email,cpf,password);

        Assertions.assertEquals(name,newUser.getName());
    }

    @Test
    public void whenToCreateANewUserButTheCPFNumberIsInvalid(){
        cpf = "11111111111";
        Assertions.assertThrows(IllegalArgumentException.class,()-> new User(name, email, cpf, password));
    }
    @Test
    public void whenToCreateANewUserButTheCPFNumIsInvalid2(){
        cpf = "32694878852";
        Assertions.assertThrows(IllegalArgumentException.class,()-> new User(name, email, cpf, password));
    }
    @Test
    public void whenToCreateANewUserButTheNameIsNull(){
        name = null;
        User newUser = new User(name,email,cpf,password);
    }
}