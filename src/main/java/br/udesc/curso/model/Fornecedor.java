package br.udesc.curso.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.udesc.curso.enums.Servico;
import lombok.Data;

@Data
@Entity
public class Fornecedor {

	@Id
	@GeneratedValue
	private long id;
	private String nome;
	
	@ElementCollection(targetClass=Servico.class)
	@Column(name="servico", nullable=false)
	@Enumerated(EnumType.STRING)
	private Set<Servico> servicos;
}
