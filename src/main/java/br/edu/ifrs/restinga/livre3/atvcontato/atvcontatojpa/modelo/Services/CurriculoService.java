package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Services;

import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Mensagem.Mensagem;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Repository.CurriculoRepository;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Contato;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CurriculoService {

    @Autowired
    CurriculoRepository curriculoRepository;

    public ResponseEntity<Object> createPdf64(Curriculo curriculo){
        curriculoRepository.save(curriculo);
        return new ResponseEntity<>(new Mensagem("Curriculo cadastrado com sucesso!"), HttpStatus.CREATED);
    }
}
