package br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Services;

import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Mensagem.Mensagem;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.Repository.ContatoRepository;
import br.edu.ifrs.restinga.livre3.atvcontato.atvcontatojpa.modelo.entidade.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public ResponseEntity<Object> createContato(Contato contato){

        if (contato.getNomeCompleto().isEmpty()){
            return new ResponseEntity<>(new Mensagem("Nome do contato não foi inserido."), HttpStatus. BAD_REQUEST);
        }if (contato.getTelefone().isEmpty()){
            return new ResponseEntity<>(new Mensagem("Numero de telefone não foi inserido."), HttpStatus. BAD_REQUEST);
        }

        contatoRepository.save(contato);
        return new ResponseEntity<>(new Mensagem("Contato criado com sucesso!"), HttpStatus.CREATED);
    }

    public Iterable<Contato> listarContatos(){
        Iterable<Contato> contatos = contatoRepository.findAll();
        return contatos;
    }

    public Optional<Contato> encontrarContato(int id){
        Optional<Contato> contatoEncontrado = contatoRepository.findById(id);
        return contatoEncontrado;
    }

    public ResponseEntity<Object> atualizarContato(int id, Contato contato){
        Optional<Contato> contatoExiste = contatoRepository.findById(id);
        if (!contatoExiste.isPresent()){
            return new ResponseEntity<>(new Mensagem("Contato não existe!"), HttpStatus.BAD_REQUEST);
        }

        contato.setId(id);
        contatoRepository.save(contato);
        return new ResponseEntity<>(new Mensagem("Contato atualizado!"), HttpStatus.CREATED);
    }

    public ResponseEntity<Object> deletarContato(int id){
        Optional<Contato> contatoExiste = contatoRepository.findById(id);

        if (!contatoExiste.isPresent()){
            return new ResponseEntity<>(new Mensagem("Contato não existe"), HttpStatus.BAD_REQUEST);
        }

    contatoRepository.deleteById(id);
    return new ResponseEntity<>(new Mensagem("Contato deletado com sucesso"), HttpStatus.ACCEPTED);
    }

}
