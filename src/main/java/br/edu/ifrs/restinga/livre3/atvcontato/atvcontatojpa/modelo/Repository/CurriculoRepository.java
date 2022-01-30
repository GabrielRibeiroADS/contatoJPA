package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Repository;

import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Contato;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Curriculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculoRepository extends CrudRepository<Curriculo, Integer> {
}
