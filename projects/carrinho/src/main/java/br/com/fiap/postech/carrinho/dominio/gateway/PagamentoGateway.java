package br.com.fiap.postech.carrinho.dominio.gateway;

import br.com.fiap.postech.carrinho.dominio.dto.CartaoDto;

import java.util.UUID;

public interface PagamentoGateway {
    UUID obterToken(String token, CartaoDto cartaoDto);
}
