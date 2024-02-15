package br.com.fiap.postech.pagamento.dominio.gateway;


import br.com.fiap.postech.pagamento.dominio.entidade.Usuario;

public interface RecuperarUsuarioAutenticadoGateway {
    Usuario getUsuario(String token);
}
