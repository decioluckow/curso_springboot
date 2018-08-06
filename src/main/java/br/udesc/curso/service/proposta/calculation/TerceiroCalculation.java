package br.udesc.curso.service.proposta.calculation;

import org.springframework.stereotype.Component;

import br.udesc.curso.vo.PropostaVO;

@Component
public class TerceiroCalculation extends PerdaTotalCalculation {

	@Override
	public float calcular(PropostaVO proposta) {
		return super.calcular(proposta) / 2;
	}

}
