package br.com.fiap.postech.carrinho.dominio.gateway;

import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;

public interface RecuperarUsuarioAutenticadoGateway {
    UsuarioDto getUsuario(String token);
}
