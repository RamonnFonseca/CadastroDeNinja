package dev.java10x.CadastroDeNinja.Missoes;
import org.springframework.web.bind.annotation.*;


//Camada de controller é a camada de apresentação para o usuário final.
@RestController // avisando que tudo que vem a baixo é um controller
@RequestMapping("/missoes") // serve para mapear a API
public class MissoesController {
    // na prática fica dessa forma (localhost:8080/missoes/...)


    // GET -- Mandar uma requisicao para mostar as missoes
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes listadas com sucesso";
    }

    // Post -- Mandar uma requisicao para criar as missoes
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missão criada com sucesso";
    }

    // PUT -- Mandar uma requisicao para alterar as missoes
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // Delete -- Mandar uma requisicao para deletar as missoes
    @DeleteMapping("/criar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }

}
