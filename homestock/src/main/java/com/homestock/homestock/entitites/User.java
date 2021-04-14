package com.homestock.homestock.entitites;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String name;
    private String email;
    private String cpf;
    private String password;

    public User(String name, String email, String cpf, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpfValidated(cpf);
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

    public String  cpfValidated(String cpf) {


        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") ||
                cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") ||
                cpf.length() != 11)  throw new IllegalArgumentException("Numero de CPF invalido");

        //Separamos os digitos verificadores
        int dig10, dig11;
        dig10 = cpf.charAt(9) -48;
        dig11 = cpf.charAt(10) - 48;
        boolean verificado1;
        boolean verificado2;
        // Calculando o primeiro digito verificador
        verificado1 = calculadoraDeVerificador(10, dig10, cpf);
        //Calculando o Segundo digito verificado
        verificado2 = calculadoraDeVerificador(11, dig11, cpf);

        return cpf;
    }

    public boolean calculadoraDeVerificador(int numeroDigitos, int digitoVerificador, String cpf) {
        int resultadoMultiplicacao;
        int contadorCaractere = 0;
        int multiplicador = 1;
        if(numeroDigitos == 11){
            contadorCaractere = 1;;
        }


        double digitoCalculado = 0;

        while (multiplicador < 10) {
            int multiplicando = cpf.charAt(contadorCaractere) - 48;
            resultadoMultiplicacao = multiplicando * multiplicador;
            digitoCalculado += resultadoMultiplicacao;
            multiplicador++;
            contadorCaractere++;
        }


        if (digitoCalculado == 10) {
            digitoCalculado = 0;
        }
        digitoCalculado = digitoCalculado%11;
        if (digitoCalculado != digitoVerificador) {
            throw new IllegalArgumentException("Numero de CPF invalido");
        }

        return true;
    }
}
