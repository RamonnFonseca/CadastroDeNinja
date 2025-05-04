package dev.java10x.CadastroDeNinja.Ninjas;

import org.springframework.web.bind.annotation.*;

/*
* Anotações importante para controllers
* EndPoint - é a class mais próxima do usuário
*/
@RestController // anotação para controlar a API Rest, passando um controlador
@RequestMapping // sempre anda junto com o RestController, coloca todas as rotas no mesmo lugar
public class NinjaController {

    @GetMapping("/boasvindas") // anotação para chamar informações da rota, como estamos chmando localhost:8080 , /boasvindas e minusculo!
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }


    // Adicionar ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado";
    }

    // Procurar todos os Ninja (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninjas";
    }

    // Mostrar ninjas por id (READ)
    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorId() {
        return "Ninja criado por id";
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
