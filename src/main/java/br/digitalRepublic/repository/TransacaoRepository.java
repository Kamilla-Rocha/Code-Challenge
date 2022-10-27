package br.digitalRepublic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.digitalRepublic.model.Transacao;



public interface TransacaoRepository extends JpaRepository<Transacao,Long> {

	public List<Transacao> findAllByTipoContainingIgnoreCase(String tipo);
	
	
	
	
	
}
