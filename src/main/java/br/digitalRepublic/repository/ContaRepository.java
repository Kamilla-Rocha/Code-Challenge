package br.digitalRepublic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.digitalRepublic.model.Conta;
import br.digitalRepublic.model.Pessoa;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	public List<Conta> findAllByTitularContainingIgnoreCase(String titular);

	public Optional<Pessoa> findByTitular(String titular);

}
