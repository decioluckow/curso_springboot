package br.udesc.curso.service.proposta;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.udesc.curso.enums.Cobertura;
import br.udesc.curso.model.Apolice;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.ApoliceRepository;
import br.udesc.curso.repository.ClienteRepository;
import br.udesc.curso.vo.PropostaVO;

@Service
public class PropostaService {

	@Autowired
	private CoberturaCalculationFactory calculationFactory;
	
	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Apolice calcular(PropostaVO proposta) {
		proposta.setCliente(getExistentCliente(proposta.getCliente()));
		float precoSeguro = 0;
		for (Cobertura cobertura : proposta.getCoberturas()) {
			precoSeguro += calculationFactory.build(cobertura).calcular(proposta);
		}
		return save(proposta, precoSeguro);
	}
	
	private Apolice save(PropostaVO proposta, float precoSeguro) {
		Apolice apolice = Apolice.builder()
				.cliente(proposta.getCliente())
				.veiculo(proposta.getVeiculo())
				.coberturas(proposta.getCoberturas())
				.preco(precoSeguro).build();
		return apoliceRepository.saveAndFlush(apolice);
	}

	private Cliente getExistentCliente(Cliente cliente) {
		Cliente existentCliente = clienteRepository.findByCpf(cliente.getCpf());
		if (existentCliente == null) {
			existentCliente = clienteRepository.saveAndFlush(cliente);
		}
		return existentCliente;
	}
	
	public Apolice aceitar(long apoliceId) {
		Optional<Apolice> apoliceOptional = apoliceRepository.findById(apoliceId);
		if (apoliceOptional.isPresent()) {
			Apolice apolice = apoliceOptional.get();
			apolice.setInicioVigencia(new Date());
			apolice.setFimVigencia(DateUtils.addYears(apolice.getInicioVigencia(), 1));
			apoliceRepository.save(apolice);
			return apolice;
		}
		return null;
	}
}
