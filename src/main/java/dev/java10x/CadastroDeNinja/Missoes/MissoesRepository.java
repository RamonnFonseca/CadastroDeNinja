package dev.java10x.CadastroDeNinja.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

//JPA tem vários métodos no banco de dados, para facilitar as coisas assim como lombok e etc.
public interface MissoesRepository extends JpaRepository <MissoesModel, Long> { // abstração do banco de dados, o jpa ajuda a lidar a facilitar o codigo, é long porque é o tipo do ID no MissoesModel

}
