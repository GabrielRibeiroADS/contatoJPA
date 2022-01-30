package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.curriculoController;

import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Services.CurriculoService;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Curriculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class Curriculos {

    @Autowired
    CurriculoService curriculoService;

    @PostMapping(path = "/cadastrarCurriculo")
    public ResponseEntity<Object> cadastrarCurriculo(@RequestBody Curriculo curriculo){
        return curriculoService.createPdf64(curriculo);
    }
}
