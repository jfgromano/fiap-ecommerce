package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Usuario;
import br.com.fiap.postech.gestaoitens.dominio.exception.AcessoNaoAutorizadoException;
import org.springframework.stereotype.Service;

@Service
public class ValidaPermissoesRecursoAction {
    public void executa(Usuario usuarioAutenticado) {
        if(usuarioAutenticado.getAdmin() == null || !usuarioAutenticado.getAdmin()) {
            throw new AcessoNaoAutorizadoException();
        }
    }
}
