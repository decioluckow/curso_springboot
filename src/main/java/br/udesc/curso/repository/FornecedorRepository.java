package br.udesc.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.udesc.curso.model.Fornecedor;

@Repository
public interface FornecedorRepository 
   extends JpaRepository<Fornecedor, Long> {
}
