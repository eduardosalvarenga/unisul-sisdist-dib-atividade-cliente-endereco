package br.unisul.aula.msendereco.repositorio;

import br.unisul.aula.msendereco.modelo.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Endereco findFirstByCep(Integer cep);
    List<Endereco> findAllByCidadeIgnoreCase(String cidade);

    }
