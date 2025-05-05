package dev.java10x.CadastroDeNinja.Missoes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinja.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@AllArgsConstructor // todos os argumento
@NoArgsConstructor // sem argumentos
@Data // getters and setters

public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeDaMissao;
    private String dificuldade;
    @OneToMany (mappedBy = "missoes") // uma missão para muitos Ninjas, ou seja, uma missão pode ter vários ninjas. E depois mapeo qual coluna irei mapear "missoes"
    @JsonIgnore // Ignora a serializaçção de looping infinito para listar certinho sem repetições.
    private List<NinjaModel> ninjas; // crio uma lista de missoes, porque uma missão pode ser para vários ninjas


}
