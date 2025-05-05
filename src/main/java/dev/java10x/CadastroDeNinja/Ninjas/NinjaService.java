package dev.java10x.CadastroDeNinja.Ninjas;


import org.springframework.stereotype.Service;

import java.util.List;
// faremos na camada service as regras de negocios
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
}
