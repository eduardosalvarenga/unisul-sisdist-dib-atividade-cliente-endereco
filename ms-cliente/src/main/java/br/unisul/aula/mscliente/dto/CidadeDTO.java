package br.unisul.aula.mscliente.dto;

import br.unisul.aula.mscliente.modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class CidadeDTO {

    private String cidade;
    private String uf;
    public Long clienteId;
    private String nome;

    public CidadeDTO(Cliente cliente, EnderecoDTO enderecoDTO) {
        this.cidade = enderecoDTO.getCidade();
        this.uf = enderecoDTO.getUf();
        this.clienteId = cliente.getId();
        this.nome = cliente.getNome();
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
