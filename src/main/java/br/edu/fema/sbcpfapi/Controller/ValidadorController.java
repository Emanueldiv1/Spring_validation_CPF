package br.edu.fema.sbcpfapi.Controller;

import br.edu.fema.sbcpfapi.Response.ValidationResponse;
import br.edu.fema.sbcpfapi.Serveci.ValidadorServici;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //marcar uma classe como um controlador de API REST
@RequestMapping(value = "/api") //permite definir o caminho da URL que acionará o método
public class ValidadorController {
    @GetMapping(value ="/cpf/{cpf}")
    public ResponseEntity<ValidationResponse> teste (@PathVariable String cpf) {
        ValidationResponse retornar = new ValidadorServici().validacao(cpf);
        if(retornar.isValidacao()){
            return ResponseEntity.status(HttpStatus.OK).body(retornar);
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT).body(retornar);
        }
    }
}


// @GetMapping mapear uma solicitação HTTP GET para um método específico em um controlador de API REST;
// {valor a ser digitado pelo usuario};
//@PathVariable é usada para vincular o valor da variável de caminho {cpf} ao parâmetro cpf do método String cpf;
//ResponseEntity: É uma classe do Spring que representa uma resposta HTTP. Ela encapsula o corpo da
// resposta, os cabeçalhos e o status;
//HttpStatusCode.valueOf(409) retorna o objeto de enumeração correspondente ao código de status HTTP 409 (Conflito).
