package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Anotações importante para controllers
* EndPoint - é a class mais próxima do usuário
*/
@RestController // anotação para controlar a API Rest, passando um controlador
@RequestMapping("/ninjas") // sempre anda junto com o RestController, coloca todas as rotas no mesmo lugar
public class NinjaController {

    private NinjaService ninjaService; // Injetando a dependência do NinjaService
    // instacio o ninja service aqui com o um construtor também para ter acesso a regra de negócios.
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas") // anotação para chamar informações da rota, como estamos chmando localhost:8080 , /boasvindas e minusculo!
    public String boasVindas(){

        return "Essa é a minha primeira mensagem nessa rota";
    }


    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) { // Anotation para o usuario incluir informação para o sistema em JSON e depois joga para o banco de dados

        return ninjaService.criarNinja(ninja);
    }

    // Procurar todos os Ninja (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas(); // pegando a função listarNinjas do meu ninja service
    }

    // Mostrar ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id) { // @PathVariable: anotation para colocar o id como parte do código, na URL para achar os ninjas por id.

        return ninjaService.listarNinjaPorId(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por id";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar ninja por id";
    }
}
