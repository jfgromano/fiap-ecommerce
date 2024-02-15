package br.com.fiap.postech.autenticacao.aplicacao.contato;

import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CriaAtualizaContato {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private BuscarContatoPorId buscarContatoPorId;

    public Contato executa(Usuario usuario, Contato contato, UUID id) {
        if(id != null){
            Contato contatoEmBanco = buscarContatoPorId.executa(usuario, id);
            contatoEmBanco.atualiza(contato);
            contato = contatoEmBanco;
        }
        contato.setUsuario(usuario);
        return contatoRepository.criaOuAtualiza(contato);
    }

    public Contato executa(Usuario usuario, Contato contato) {
        return this.executa(usuario, contato, null);
    }
}