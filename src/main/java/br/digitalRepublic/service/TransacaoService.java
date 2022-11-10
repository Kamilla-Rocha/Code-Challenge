package br.digitalRepublic.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.digitalRepublic.Exception.ContaNotFoundException;
import br.digitalRepublic.Exception.DefaultException;
import br.digitalRepublic.Exception.SaldoInsuficienteException;
import br.digitalRepublic.Exception.TransacaoSuperiorPermitidoException;
import br.digitalRepublic.model.Conta;
import br.digitalRepublic.model.Transacao;
import br.digitalRepublic.repository.ContaRepository;
import br.digitalRepublic.repository.TransacaoRepository;

@Service
public class TransacaoService {

	private ContaRepository contaRepository;

	private TransacaoRepository transacaoRepository;

	public TransacaoService(ContaRepository contarepository, TransacaoRepository transacaoRepository) {
		this.contaRepository = contaRepository;
		this.transacaoRepository = transacaoRepository;

	}

	public void transacionar(Transacao transacao) throws DefaultException {
		switch (transacao.getTipo().getCode()) {
		case 1:
			transferir(transacao);
			break;

		case 2:
			depositar(transacao);
			break;
		}

	}

	private void depositar(Transacao transacao) throws ContaNotFoundException {
		Optional<Conta> destinatario = contaRepository.findById(transacao.getDestinatarioId());

		Conta conta = verificarConta(destinatario);
		conta.setSaldo(conta.getSaldo().add(transacao.getValor()));

		contaRepository.save(conta);
		transacaoRepository.save(transacao);

	}

	private void transferir(Transacao transacao) throws DefaultException {
		Optional<Conta> remetente = contaRepository.findById(transacao.getRemetenteId());
		Optional<Conta> destinatario = contaRepository.findById(transacao.getDestinatarioId());

		Conta remetenteValido = verificarConta(remetente);
		Conta destinatarioValido = verificarConta(destinatario);

		if (transacao.getValor().doubleValue() > 2000) {
			throw new TransacaoSuperiorPermitidoException(HttpStatus.UNPROCESSABLE_ENTITY.value(),
					"O limite máximo por transação é de  R$2.000,00");

		}

		if (remetenteValido.getSaldo().doubleValue() < transacao.getValor().doubleValue()) {
			throw new SaldoInsuficienteException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Saldo Insuficiente");
		}

		remetenteValido.setSaldo(remetenteValido.getSaldo().subtract(transacao.getValor()));
		destinatarioValido.setSaldo(destinatarioValido.getSaldo().add(transacao.getValor()));

		contaRepository.save(remetenteValido);
		contaRepository.save(destinatarioValido);
		transacaoRepository.save(transacao);

	}

	private Conta verificarConta(Optional<Conta> conta) throws ContaNotFoundException {
		if (conta.isEmpty()) {
			throw new ContaNotFoundException(HttpStatus.NOT_FOUND.value(), "Conta não encontrada");
		}
		return conta.get();

	}

}
	
	
	
