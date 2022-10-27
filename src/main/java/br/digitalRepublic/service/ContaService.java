package br.digitalRepublic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import br.digitalRepublic.model.Pessoa;
import br.digitalRepublic.repository.PessoaRepository;

@Service
public class ContaService<ContaPessoa> {

	
	@Autowired
	private PessoaRepository pessoaRepository;
	

	// função para buscar uma pessoa ja cadastrada
	public Optional<Pessoa> buscaPessoa(Pessoa pessoa) {

		
		
		// verificar se o Cpf já existe
		if (pessoaRepository.findByCpf(pessoa.getCpf()).isPresent()) {
			Optional<Pessoa> buscaPessoa = pessoaRepository.findByCpf(pessoa.getCpf());
			
			

			// valida se o usuario esta presente no banco de dados
			if ((buscaPessoa.isPresent()));
				

			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta já existe !", null);

			
		}
		return Optional.empty();
				
			
				
			}
		}
		

		
	
		
	

	

         


		 


	

	


	
	
	


	


	
	


		
	



	
	
	
	
	


