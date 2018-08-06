package br.udesc.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Apolice;
import br.udesc.curso.service.proposta.PropostaService;
import br.udesc.curso.vo.PropostaVO;

@RestController
@RequestMapping("proposta")
public class PropostaController {

	@Autowired
	private PropostaService service;
	
	@PostMapping("/calcular")
	public Apolice calculate(@RequestBody PropostaVO propostaVO) {
		
		return service.calcular(propostaVO);
	}
	
	@PostMapping("/aceitar/{apoliceId}")
	public Apolice find(@PathVariable("apoliceId") long apoliceId) {
		return service.aceitar(apoliceId);
	}
}
