package dev.java10x.CadastroDeNinja.Ninjas;
import dev.java10x.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO { //Basicamente é uma cópia do NinjaModel(entidade do banco de dados) só que não tem acesso ao banco de dados. Usado como proteção
    // Não preciso colocas as anotações de tabela porque o DTO não tem acesso ao banco de dados, logo, posso tirar todas as anotações de banco de dados
    // DTO tira a responsabilidade da entidade
    private long id;
    private String nome;
    private String email;
    private int idade;
    private MissoesModel missoes;
    private String rank;

}
