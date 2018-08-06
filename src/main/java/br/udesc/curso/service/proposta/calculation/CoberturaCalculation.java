package br.udesc.curso.service.proposta.calculation;

import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;

public abstract class CoberturaCalculation {

	public float calcular(PropostaVO proposta) {
		Veiculo veiculo = proposta.getVeiculo();
		return calcularValor(proposta) + 
				(calcularPercentualVeiculo(proposta) * veiculo.getValor());
	}

	abstract float calcularValor(PropostaVO proposta);

	abstract float calcularPercentualVeiculo(PropostaVO proposta);
}
