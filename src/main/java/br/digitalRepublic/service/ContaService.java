
package br.digitalRepublic.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Random;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import br.digitalRepublic.Exception.ContaExistException;
import br.digitalRepublic.model.Conta;
import br.digitalRepublic.model.Pessoa;
import br.digitalRepublic.repository.ContaRepository;
import br.digitalRepublic.repository.PessoaRepository;

@Service
public class ContaService {

	private static final Integer AGENCIA_DEFAULT = 977;

	private PessoaRepository pessoaRepository;

	private ContaRepository contaRepository;

	public ContaService(ContaRepository repository, PessoaRepository pessoaRepository) {
		this.contaRepository = repository;
		this.pessoaRepository = pessoaRepository;
	}

	public Conta criarContaPessoa(Pessoa pessoa) throws ContaExistException {
		Optional<Conta> conta = contaRepository.findByPessoa_Cpf(pessoa.getCpf());
		if (conta.isPresent()) {
			throw new ContaExistException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Conta já existe");

		}
		return abrirConta(pessoa);

	}

	private Conta abrirConta(Pessoa pessoa) {
		Conta conta = new Conta();
		conta.setAgencia(AGENCIA_DEFAULT);
		conta.setConta(new Random().nextInt(1000) + 8888);
		conta.setPessoa(cadastrarPessoa(pessoa));
		conta.setSaldo(BigDecimal.valueOf(0));
		contaRepository.save(conta);
		return conta;

	}

	private Pessoa cadastrarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

}
				