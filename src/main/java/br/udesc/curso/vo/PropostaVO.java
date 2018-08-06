package br.udesc.curso.vo;

import java.util.Set;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PropostaVO {

	private Cliente cliente;
	private Veiculo veiculo;
	private Set<Cobertura> coberturas;

}
