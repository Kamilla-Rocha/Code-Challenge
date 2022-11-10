package br.digitalRepublic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.digitalRepublic.Exception.ContaExistException;
import br.digitalRepublic.model.Conta;
import br.digitalRepublic.model.Pessoa;
import br.digitalRepublic.service.ContaService;

@RestController
@RequestMapping("/criar/contaPessoa")
public class ContaController {

	private ContaService contaService;

	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}

	@PostMapping("/criar{contaPessoa}")
	public ResponseEntity<Conta> criarContaPessoa(@RequestBody Pessoa criarContaPessoa, Pessoa Pessoa)
			throws ContaExistException {
		return ResponseEntity.ok(contaService.criarContaPessoa(Pessoa));

	}

}







