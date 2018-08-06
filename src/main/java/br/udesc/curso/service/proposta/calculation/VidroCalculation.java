package br.udesc.curso.service.proposta.calculation;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class VidroCalculation extends CoberturaCalculation{
	@Override
	float calcularValor(PropostaVO proposta) {
		return 100;
	}

	@Override
	float calcularPercentualVeiculo(PropostaVO proposta) {
		return 0;
	}

}
