package dev.java10x.CadastroDeNinja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // anotação para controlar a API Rest, passando um controlador
@RequestMapping // sempre anda junto com o RestController, coloca todas as rotas no mesmo lugar
public class Controller {

    @GetMapping("/boasvindas") // anotação para chamar informações da rota, como estamos chmando localhost:8080 , /boasvindas e minusculo!
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

}
