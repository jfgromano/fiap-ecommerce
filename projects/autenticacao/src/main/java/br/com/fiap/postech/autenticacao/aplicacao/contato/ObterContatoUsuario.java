package br.com.fiap.postech.autenticacao.aplicacao.contato;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.exception.ContatoNaoCadastradoException;
import br.com.fiap.postech.autenticacao.dominio.repositorio.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterContatoUsuario {
    @Autowired
    private ContatoRepository repository;

    public Contato executa(Usuario usuario) {
        Optional<Contato> contato = this.repository.buscaPorIdUsuario(usuario.getId());
        if(contato.isEmpty()) {
            throw new ContatoNaoCadastradoException();
        }
        return contato.get();
    }
}
