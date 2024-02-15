package br.com.fiap.postech.carrinho.dominio.repositorio;

import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    Pedido salvarAtualizar(Pedido pedido);
    Optional<Pedido> buscarPorId(UUID id);
}