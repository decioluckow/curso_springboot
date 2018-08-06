package br.udesc.curso.service.proposta.calculation;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.udesc.curso.model.Cliente;
import br.udesc.curso.model.Veiculo;
import br.udesc.curso.vo.PropostaVO;

public class CarroReservaCalculationTest {

    @Test
    public void apoliceComCarroReserva() {
        Cliente cliente = Cliente.builder().nascimento(new Date(2000-1900, 10, 1)).build();
        Veiculo veiculo = Veiculo.builder().anoFabricacao(2014).valor(10000).build();
        PropostaVO proposta = PropostaVO.builder().cliente(cliente).veiculo(veiculo).build();
        CarroReservaCalculation carroReservaCalculation = new CarroReservaCalculation();

        float valor = carroReservaCalculation.calcular(proposta);

        Assert.assertEquals(100, valor, 0 );
    }

}