package br.edu.fema.sbcpfapi.Serveci;

import br.edu.fema.sbcpfapi.Response.ValidationResponse;

public class ValidadorServici {

    public ValidationResponse validacao(String cpf){

        String digitosFinais = lerDigitosFinais(cpf);

        String digitoUM = recuperarDigitoUm(cpf);

        String digitoDois = recuperarDigitoDois(cpf, digitoUM);

        String verificadoresDigitos = digitoUM + digitoDois;

       Boolean cpfEstavalido = verificadoresDigitos.equals(digitosFinais);

       ValidationResponse retornodeValidacao = new ValidationResponse();
       retornodeValidacao.setCpf(cpf);
       retornodeValidacao.setValidacao(cpfEstavalido);
       retornodeValidacao.setStatus(geradorStatus(cpfEstavalido));
       retornodeValidacao.setDigits(digitoUM + digitoDois);
       return  retornodeValidacao;
    }

    private String geradorStatus(Boolean cpfEstavalido){
        if (cpfEstavalido){
            return "CPF valido";
        }
        return "CPF invalido";
    }

    private String lerDigitosFinais(String cpf){
        return cpf.substring(9);
    }

    public String recuperarDigitoUm(String cpf){
        String noveDigitos = cpf.substring(0,9);
        char[] digitos = noveDigitos.toCharArray();
        Integer soma = 0;
        Integer multiplicar = 10;

        for(int i = 0; i < digitos.length;  i++){
            soma = soma + Character.getNumericValue(digitos[i]) * multiplicar;
            multiplicar --;
        }

        Integer resto = soma % 11;
        if (resto < 2){
            return "0";
        }
        else {
            return String.valueOf(11 - resto );
        }

    }


    public String recuperarDigitoDois(String cpf, String digitoUM){
        String noveDigitosmais1 = cpf.substring(0,9) + digitoUM;
        char[] digitos = noveDigitosmais1.toCharArray();
        Integer soma = 0;
        Integer multiplicar = 11;

        for(int i = 0; i < digitos.length;  i++){
            soma = soma + Character.getNumericValue(digitos[i]) * multiplicar;
            multiplicar --;
        }

        Integer resto = soma %11;
        if (resto < 2){
            return "0";
        }
        else {
            return String.valueOf(11 - resto );
        }

    }
}
