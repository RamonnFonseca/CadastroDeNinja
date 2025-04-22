package dev.java10x.CadastroDeNinja.Ninjas;

import dev.java10x.CadastroDeNinja.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

// JPA - Java Persistence API
@Entity // transformo toda a classe numa entidade do meu banco de dados, basicamente aviso ao sistema que irei criar uma tabela no banco de dados com ostributos dessa classe.
@Table(name = "tb_cadastro") // dando nome para tabela de cadastro de ninjas, usamos o @Table. como boas práticas colocamos o nome do jeito que está aí.

public class NinjaModel { // nossa classe de atributos, ou seja, nosso modelos de ninjas

    @Id // serve para gerar o ID automáticamente para a tabela de cadastro de ninja
    @GeneratedValue(strategy = GenerationType.IDENTITY) // a estratégia como os IDs seram gerados. anda junto com o @Id. nesse caso serão números sequenciais.
    private long id; // diferencia os ninjas por para serem únicos dentro do banco de dados. Não precisa criar um construtor para ele. encrementa automático
    private String nome;
    private String email;
    private int idade;
    @ManyToOne // Serve para mostrar que o Ninja ou serviço tem uma unica missão. Ou seja, leia-se " muitos ninjas teram a penas uma missão".
    @JoinColumn(name = "missoes_id") // foreing key ou chave estrangeira, se conectando com a tabela de missoes. e damos um nome para uma nova coluna que estará conectada com a tabela secundária missoes.
    private MissoesModel missoes;


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
