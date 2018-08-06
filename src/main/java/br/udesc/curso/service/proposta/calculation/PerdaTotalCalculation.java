package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.vo.PropostaVO;

@Component
public class PerdaTotalCalculation extends CoberturaCalculation {

	@Override
	float calcularValor(PropostaVO proposal) {
		return 0;
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposta) {
		Cliente cliente = proposta.getCliente();
		int idadeCliente = (new Date().getYear()) - cliente.getNascimento().getYear();
		float percentual = 0;
		if (idadeCliente < 24) {
			percentual = 0.05f;
		} else if (idadeCliente >= 24 && idadeCliente < 40) {
			percentual = 0.03f;
		} else {
			percentual = 0.01f;
		}
		return percentual;
	}

}
