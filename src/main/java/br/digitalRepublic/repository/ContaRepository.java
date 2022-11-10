package br.digitalRepublic.repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.digitalRepublic.model.Conta;



@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

	public Optional<Conta>  findByPessoa_Cpf(String cpf);

	
}