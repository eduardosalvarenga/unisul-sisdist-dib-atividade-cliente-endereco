package br.unisul.aula.mscliente.servico;

import br.unisul.aula.mscliente.dto.CidadeDTO;
import br.unisul.aula.mscliente.dto.ClienteDTO;
import br.unisul.aula.mscliente.dto.EnderecoDTO;
import br.unisul.aula.mscliente.modelo.Cliente;
import br.unisul.aula.mscliente.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

  //  @Autowired
  //  private CidadeRepository cidadeRepository;

   // @Autowired
   // private RestTemplate clienteRaimbow;

    @Autowired
    private EnderecoClient enderecoClient;

    public List<ClienteDTO> listarTodos() {
        List<ClienteDTO> dtos = new ArrayList<>();
        for (Cliente cliente: clienteRepository.findAll()){
            EnderecoDTO enderecoDTO = buscarEnderecoPorID(cliente.getEndereco_id());
            ClienteDTO clienteDTO = new ClienteDTO(cliente, enderecoDTO);
            dtos.add(clienteDTO);
        }
        return dtos;
    }

    public List<CidadeDTO> listarPorCidade(String cidade) {
        List<CidadeDTO> dtos = new ArrayList<>();
        for (Cliente cliente: clienteRepository.findAll()){
            EnderecoDTO enderecoDTO = buscarEnderecoPorID(cliente.getEndereco_id());
            CidadeDTO cidadeDTO = new CidadeDTO(cliente, enderecoDTO);
            dtos.add(cidadeDTO);
        }
        List<CidadeDTO> listaFiltrada = dtos.stream()
                .filter(clientes -> clientes.getCidade().equalsIgnoreCase(cidade))
                .collect(Collectors.toList());

        return listaFiltrada;
    }

    private EnderecoDTO buscarEnderecoPorID(Long id){
        return enderecoClient.buscarPorId(id);
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep){
        return enderecoClient.buscarPorCep(cep);
    }

/*
    private EnderecoDTO buscarEnderecoPorID(Long id) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/id/" + id,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
    private EnderecoDTO buscarEnderecoPorCep(Integer cep) {
        ResponseEntity<EnderecoDTO> exchange = clienteRaimbow.exchange("http://endereco/end/" + cep,
                HttpMethod.GET, null, EnderecoDTO.class);
        return exchange.getBody();
    }
*/

    public void registrarCliente(ClienteDTO dto) {
        dto.setEndereco(buscarEnderecoPorCep(dto.getCep()));
        Cliente cliente = dto.converterParaCliente();
        clienteRepository.save(cliente);
    }

}
