package br.edu.fema.sbcpfapi.Response;

import lombok.Getter;
import lombok.Setter;

@Getter //poder acessar o valor de outra parte do codigo;
@Setter // Esse método permite vc modificar o valor do campo setNome(String nome);
public class ValidationResponse {
    private String cpf;
    private String status;
    private boolean validacao;
    private String digits;
}

