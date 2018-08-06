package br.udesc.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.udesc.curso.model.Cliente;

@Repository
@Transactional(readOnly = true)
public interface ClienteRepository 
   extends JpaRepository<Cliente, Long> {
	
	Long countByCidade_Id(Long cidadeId);
	
	Cliente findByCpf(String cpf);

	List<Cliente> findByCidade_Nome(String cdiadeNome);

	List<Cliente> findByNomeContaining(String nome);

	List<Cliente> findByNomeContainingIgnoreCase(String nome);

	List<Cliente> findByResideComFaixaRiscoTrue();

	List<Cliente> findByNomeContainingIgnoreCaseOrCidade_NomeContainingIgnoreCase(String clienteNome, String cidadeNome);

	List<Cliente> findByCidade_IdIn(List<Long> cidadeIds);

	@Transactional
	@Modifying
	@Query(value = "update Cliente c set c.resideComFaixaRisco = :valor where c.id = :clienteId")
	int modificaClienteResideFaixaRisco(@Param("clienteId") Long id, @Param("valor") Boolean resideComFaixaRisco);
}
