package br.com.fiap.postech.autenticacao.aplicacao;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.exception.AcessoNaoAutorizadoException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidaPermissoesRecursoAction {
    public void executa(Usuario usuarioAutenticado, UUID idUsuarioRecurso) {
        if(usuarioAutenticado == null || idUsuarioRecurso == null) {
            throw new AcessoNaoAutorizadoException();
        }

        if(!idUsuarioRecurso.equals(usuarioAutenticado.getId())) {
            throw new AcessoNaoAutorizadoException();
        }
    }
}
