package br.udesc.curso.service.proposta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.service.proposta.calculation.AssistenciaCalculation;
import br.udesc.curso.service.proposta.calculation.CarroReservaCalculation;
import br.udesc.curso.service.proposta.calculation.CoberturaCalculation;
import br.udesc.curso.service.proposta.calculation.PerdaTotalCalculation;
import br.udesc.curso.service.proposta.calculation.TerceiroCalculation;

@Component
public class CoberturaCalculationFactory {

	@Autowired
	private PerdaTotalCalculation perdaTotalCalculation;

	@Autowired
	private CarroReservaCalculation carroReservaCalculation;
	
	@Autowired
	private TerceiroCalculation terceiroCalculation;
	
	@Autowired
	private AssistenciaCalculation assistenciaCalculation;

	public CoberturaCalculation build(Cobertura cobertura) {
		switch (cobertura) {
		case PERDA_TOTAL:
			return perdaTotalCalculation;
		case CARRO_RESERVA:
			return carroReservaCalculation;
		case TERCEIROS:
			return terceiroCalculation;
		case ASSISTENCIA:
			return assistenciaCalculation;
		default:
			throw new IllegalArgumentException("Calculo para a cobertura " + cobertura + " não implementado");
		}
	}
}
