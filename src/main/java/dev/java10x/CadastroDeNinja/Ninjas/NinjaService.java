package dev.java10x.CadastroDeNinja.Ninjas;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

// faremos na camada service as regras de negocios ou seja toda lógica
// Camada mais próxima do usuário
@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper; // injeção de dependecia do NinjaMapper que é a camada de mapeamento do DTO e depois colocar como construtor

    // inicializo um construtor normal quando for trabalhar com a injeção de dependência, ou serviços.
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
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
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) { // metodo do tipo NinjaModel para criar os ninjas usando como parâmetro a própria classe NinjaModel
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja); // metodo do JPA para salvar a criação de ninjas novos, mesma propriedade de ISERT em SQL
        return ninjaMapper.map(ninja);
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
