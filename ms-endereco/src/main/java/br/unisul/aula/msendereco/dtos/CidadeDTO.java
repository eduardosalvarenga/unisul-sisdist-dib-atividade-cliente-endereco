package br.unisul.aula.msendereco.dtos;

import br.unisul.aula.msendereco.modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

public class CidadeDTO {

    private Long id;
    private String cidade;
    private String uf;

    public CidadeDTO(Endereco endereco) {
        this.cidade = endereco.getCidade();
        this.uf = endereco.getUf().name();
    }

    public Long getId() { return id; }

    public void setId(Long id) {this.id = id;}

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


}
