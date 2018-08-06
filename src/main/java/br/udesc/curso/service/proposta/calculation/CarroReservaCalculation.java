package br.udesc.curso.service.proposta.calculation;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class CarroReservaCalculation extends CoberturaCalculation {

	@Override
	float calcularValor(PropostaVO proposal) {
	    return 100;
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposal) {
		return 0;
	}

}
