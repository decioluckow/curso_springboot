package br.udesc.curso.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.udesc.curso.enums.CategoriaCNH;
import lombok.Data;

@Data
@Embeddable
public class CNH {

	@Temporal(TemporalType.DATE)
	private Date emissao;
	
	@Enumerated(EnumType.STRING)
	private CategoriaCNH categoria;
	
	@Temporal(TemporalType.DATE)
	private Date validade;
}
