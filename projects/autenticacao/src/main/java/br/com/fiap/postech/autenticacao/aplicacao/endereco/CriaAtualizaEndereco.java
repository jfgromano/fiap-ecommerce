package br.com.fiap.postech.autenticacao.aplicacao.endereco;

import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.EnderecoRepository;
import br.com.fiap.postech.autenticacao.dominio.exception.EnderecoNaoCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CriaAtualizaEndereco {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private BuscarEnderecoPorId buscarEnderecoPorId;

    public Endereco executa(Usuario usuario, Endereco endereco, UUID id) throws EnderecoNaoCadastradoException {
        if(id != null){
            Endereco enderecoEmBanco = buscarEnderecoPorId.executa(usuario, id);
            enderecoEmBanco.atualiza(endereco);
            endereco = enderecoEmBanco;
        }
        endereco.setUsuario(usuario);
        return enderecoRepository.criaOuAtualiza(endereco);
    }

    public Endereco executa(Usuario usuario, Endereco endereco) {
        return this.executa(usuario, endereco, null);
    }
}