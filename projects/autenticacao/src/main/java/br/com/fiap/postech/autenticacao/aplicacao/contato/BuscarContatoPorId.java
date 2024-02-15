package br.com.fiap.postech.autenticacao.aplicacao.contato;

import br.com.fiap.postech.autenticacao.aplicacao.ValidaPermissoesRecursoAction;
import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.exception.ContatoNaoCadastradoException;
import br.com.fiap.postech.autenticacao.dominio.repositorio.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscarContatoPorId {
    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    public Contato executa(Usuario usuario, UUID id) {
        Optional<Contato> contatoEmBanco = contatoRepository.buscaPorId(id);
        if(contatoEmBanco.isEmpty()) {
            throw new ContatoNaoCadastradoException();
        }
        validaPermissoesRecursoAction.executa(usuario, contatoEmBanco.get().getUsuario().getId());
        return contatoEmBanco.get();
    }

}
