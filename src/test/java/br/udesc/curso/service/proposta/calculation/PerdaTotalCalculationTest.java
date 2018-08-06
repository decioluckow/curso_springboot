package br.udesc.curso.service.proposta.calculation;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class PerdaTotalCalculationTest {

	@Test
	public void testVidaLoka() {
		Cliente cliente = Cliente.builder().nascimento(new Date(2000-1900, 10, 1)).build();
		Veiculo veiculo = Veiculo.builder().anoFabricacao(2014).valor(10000).build();
		PropostaVO proposta = PropostaVO.builder().cliente(cliente).veiculo(veiculo).build();
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();

		float insurancePrice = calculation.calcular(proposta);
		Assert.assertEquals(500, insurancePrice, 0);
	}
	
	@Test
	public void testTiozao() {
		Cliente cliente = Cliente.builder().nascimento(new Date(1982-1900, 10, 1)).build();
		Veiculo veiculo = Veiculo.builder().anoFabricacao(2014).valor(10000).build();
		PropostaVO proposta = PropostaVO.builder().cliente(cliente).veiculo(veiculo).build();
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		
		float insurancePrice = calculation.calcular(proposta);
		
		Assert.assertEquals(300, insurancePrice, 0);
	}
	
	@Test
	public void testVovo() {
		Cliente cliente = Cliente.builder().nascimento(new Date(1970-1900, 10, 1)).build();
		Veiculo veiculo = Veiculo.builder().anoFabricacao(2014).valor(10000).build();
		PropostaVO proposta = PropostaVO.builder().cliente(cliente).veiculo(veiculo).build();
		PerdaTotalCalculation calculation = new PerdaTotalCalculation();
		
		float insurancePrice = calculation.calcular(proposta);
		
		Assert.assertEquals(100, insurancePrice, 0);
	}
}
