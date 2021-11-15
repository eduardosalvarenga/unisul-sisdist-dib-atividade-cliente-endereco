package br.unisul.aula.mscliente.controle;

import br.unisul.aula.mscliente.dto.CidadeDTO;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import br.unisul.aula.mscliente.servico.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cli")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/")
    public List<ClienteDTO> listarTodosClientes(){
        return service.listarTodos();
    }

    @GetMapping("/cidade/{cidade}")
    public List<CidadeDTO> listarClientesPorCidade(@PathVariable(name = "cidade")String cidade) {
        return service.listarPorCidade(cidade);
    }

    @PostMapping("/")
    public void inserirCliente(@RequestBody ClienteDTO dto){
        service.registrarCliente(dto);
    }
}
