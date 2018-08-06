package br.udesc.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Fornecedor;
import br.udesc.curso.repository.FornecedorRepository;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepository repository;

	@PostMapping("/salvar")
	public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
		return repository.saveAndFlush(fornecedor);
	}
}
