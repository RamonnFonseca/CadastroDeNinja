package dev.java10x.CadastroDeNinja.Ninjas;

import dev.java10x.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// JPA - Java Persistence API
@Entity // transformo toda a classe numa entidade do meu banco de dados, basicamente aviso ao sistema que irei criar uma tabela no banco de dados com ostributos dessa classe.
@Table(name = "tb_cadastro") // dando nome para tabela de cadastro de ninjas, usamos o @Table. como boas práticas colocamos o nome do jeito que está aí.

// Lombok
@NoArgsConstructor // Anotação para criação de construtores vazios "Lombok"
@AllArgsConstructor // anotação para construtores com argumentos
@Data // Anotação para criar os getters e setters com o "lombok"

public class NinjaModel { // nossa classe de atributos, ou seja, nosso modelos de ninjas

    @Id // serve para gerar o ID automáticamente para a tabela de cadastro de ninja
    @GeneratedValue(strategy = GenerationType.IDENTITY) // a estratégia como os IDs seram gerados. anda junto com o @Id. nesse caso serão números sequenciais.
    @Column(name = "id")
    private long id; // diferencia os ninjas por para serem únicos dentro do banco de dados. Não precisa criar um construtor para ele. encrementa automático

    @Column(name = "nome")
    private String nome;

    @Column(unique = true) // estou falando que essa coluna é única, não tem itens repetidos ou seja um pessoal no banco de dados terá apenas um unico e-mail
    private String email;

    @Column (name = "rank") // adicionei essa migration depois de finalizar o banco de dados, e só é possível porque criei o DTO, mas primeiro preciso criar a migration para depois adicionar aqui ao banco de ados
    private String rank;

    @Column(name = "idade")
    private int idade;

    @ManyToOne // Serve para mostrar que o Ninja ou serviço tem uma unica missão. Ou seja, leia-se " muitos ninjas teram a penas uma missão".
    @JoinColumn(name = "missoes_id") // foreing key ou chave estrangeira, se conectando com a tabela de missoes. e damos um nome para uma nova coluna que estará conectada com a tabela secundária missoes.
    private MissoesModel missoes; // cada ninja terá apenas uma missão


}
