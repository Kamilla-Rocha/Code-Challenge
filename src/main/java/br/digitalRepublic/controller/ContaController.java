package br.digitalRepublic.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import br.digitalRepublic.model.Pessoa;
import br.digitalRepublic.repository.PessoaRepository;

@RequestMapping("/criar/conta")
public class ContaController {

	
	
	@Autowired
	private PessoaRepository pessoaRepository;

	// Metodo do tipo ResponseEntity para responnder a requisição, com uma HTTP
	// Response (Resposta http),
	// neste caso Response Status 201 => CREATED, para inserir a pessoa no banco de
	// dados

	@PostMapping("/cadastrar")
	public ResponseEntity<Pessoa> postPessoa(@Valid @RequestBody Pessoa pessoa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaRepository.save(pessoa));
	}

	
	// A intenção era criar os metodos indicando um requisição para pegar as
	// informações do  nome, sobrenome e cpf
	// para abrir uma conta com as informações da pessoa,

	
	
	@GetMapping({ "/{cpf}" })
	public Optional<Pessoa> findByCpf(@PathVariable String cpf) {
		return pessoaRepository.findByCpf(cpf);

	}
	
	

	@GetMapping({ "/nome/{nome}" })
	public Optional<Pessoa> findByNome(@PathVariable String nome) {
		return pessoaRepository.findByNome(nome);

		
	}

	@GetMapping({ "/sobrenome{sobrenome}" })
	public Optional<Pessoa> findBySobrenome(@PathVariable String sobrenome) {
		return pessoaRepository.findBysobrenome(sobrenome);

	}

}


