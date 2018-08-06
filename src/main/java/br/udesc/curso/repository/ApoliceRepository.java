package br.udesc.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.udesc.curso.model.Apolice;

@Repository
public interface ApoliceRepository 
   extends JpaRepository<Apolice, Long> {
}
