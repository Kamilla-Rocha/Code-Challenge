package br.digitalRepublic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.digitalRepublic.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
