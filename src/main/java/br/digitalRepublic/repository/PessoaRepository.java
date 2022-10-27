package br.digitalRepublic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.digitalRepublic.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public Optional<Pessoa> findByCpf(String cpf);

	public Optional<Pessoa> findByNome(String nome);

	public Optional<Pessoa> findBysobrenome(String sobrenome);

	public Object findAllByCpfContainingIgnoreCase(String cpf);

}
