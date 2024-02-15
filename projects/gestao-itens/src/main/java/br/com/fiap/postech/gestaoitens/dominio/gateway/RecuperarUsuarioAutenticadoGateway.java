package br.com.fiap.postech.gestaoitens.dominio.gateway;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Usuario;

public interface RecuperarUsuarioAutenticadoGateway {
    Usuario getUsuario(String token);
}
