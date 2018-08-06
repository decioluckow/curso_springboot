package br.udesc.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.udesc.curso.model.Cidade;

@Repository
public interface CidadeRepository 
   extends JpaRepository<Cidade, Long> {

}
