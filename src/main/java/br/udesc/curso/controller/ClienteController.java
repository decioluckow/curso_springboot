package br.udesc.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.udesc.curso.model.Cidade;
import br.udesc.curso.model.Cliente;
import br.udesc.curso.repository.CidadeRepository;
import br.udesc.curso.repository.ClienteRepository;

@RestController
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@PostMapping("/salvar")
	public Cliente salvar(@RequestBody Cliente cliente) {
		long cidadeId = cliente.getCidade().getId();
		Cidade cidade = cidadeRepository.findById(cidadeId).get();
		cliente.setCidade(cidade);
		return repository.saveAndFlush(cliente);
	}
	
	@GetMapping("encontrar/{id}")
	public Cliente find(@PathVariable("id") long id) {
		return repository.findById(id).get();
	}
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		return repository.findAll();
	}
	
	@DeleteMapping("excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable("id") long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
