package dev.java10x.CadastroDeNinja.Ninjas;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// faremos na camada service as regras de negocios ou seja toda lógica
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    // inicializo um construtor normal quando for trabalhar com a injeção de dependência, ou serviços.
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public NinjaModel listarNinjaPorId(long id){
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id); // uso o optional porque o ninja pode ou não existir para procurar os ninjas e uso o findById método para procurar por id
        return ninjaPorId.orElse(null);// orElse: metodo para que se não existir o id, retorna null
    }

    // Criar um novo ninja
    public NinjaModel criarNinja(NinjaModel ninja) { // metodo do tipo NinjaModel para criar os ninjas usando como parâmetro a própria classe NinjaModel
        return ninjaRepository.save(ninja); // metodo do JPA para salvar a criação de ninjas novos, mesma propriedade de ISERT em SQL
    }

    // Deletar ninja - Tem que ser um método void
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja - basicamente é uma mistura de get com post, porque primeiro vou requisitar uma id para depois alterar o ninja na tabela
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){ // primeiro lista o id e depois vai subscrever com a nova atualização
        if (ninjaRepository.existsById(id)){ // Se ele existir ou seja, se o ninja existe "existById"
            ninjaAtualizado.setId(id); // vou lá e atualizo com novos dados setando com "setId"
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null; // se não tiver ninja, retona null
    }


}
