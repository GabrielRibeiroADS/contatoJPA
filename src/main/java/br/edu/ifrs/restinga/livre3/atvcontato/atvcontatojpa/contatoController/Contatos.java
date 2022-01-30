package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.contatoController;

import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Repository.ContatoRepository;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Services.ContatoService;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class Contatos {

    @Autowired
    ContatoService contatoService;

    @PostMapping(path = "/cadastrarContato")
    public ResponseEntity<Object> cadastrarContato(@RequestBody Contato contato){
        return contatoService.createContato(contato);
    }

    @GetMapping(path = "/listarContatos")
    public Iterable<Contato> listarContato(){
        return contatoService.listarContatos();
    }

    @GetMapping(path = "/recuperarContato/{id}")
    public Optional<Contato> recuperarContato(@PathVariable int id){ return contatoService.encontrarContato(id); }

    @PutMapping(path = "/atualizarContato/{id}")
    public ResponseEntity<Object> atualizarContato(@PathVariable("id") int id, @RequestBody Contato contato){ return contatoService.atualizarContato(id, contato);}

    @DeleteMapping(path = "/deletarContato/{id}")
    public ResponseEntity<Object> deletarContato(@PathVariable int id){ return contatoService.deletarContato(id);}

}
