package br.digitalRepublic.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.digitalRepublic.model.Pessoa;




@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	
	
}


	

