package com.homestock.homestock.entitites;

import java.util.Objects;

public class User {
    private String name;
    private String email;
    private String cpf;
    private String password;

    public User(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(cpf, user.cpf) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, cpf, password);
    }

    public boolean cpfValidated(String cpf){


        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
                cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") ||
                cpf.length()!=11) return false;

        //Separamos os digitos verificadores
        char dig10, dig11;
        dig10 = cpf.charAt(9);
        dig11 = cpf.charAt(10);
        boolean verificado1;
        boolean verificado2;
        // Calculando o primeiro digito verificador
        verificado1 = calculadoraDeVerificador(10,dig10,cpf);
        verificado2 = calculadoraDeVerificador(11,dig11,cpf);

        if(verificado1 == true && verificado2 ==true){
            return true;
        }else return false;


    }

    public boolean calculadoraDeVerificador(int numeroDigitos, int digitoVerificador, String cpf){
        int resultadoMultiplicacao;
        int contadorCaractere = 0;
        double digitoCalculado = 0;
        while (numeroDigitos >= 2){
            resultadoMultiplicacao = numeroDigitos * cpf.charAt(contadorCaractere);
            numeroDigitos--;
            contadorCaractere++;
            digitoCalculado = digitoCalculado + resultadoMultiplicacao;
        }
        if (digitoCalculado == 10){digitoCalculado = 0;};
        if (digitoCalculado == digitoVerificador){
            return true;
        };
        return false;
    }
}
