package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;
import br.com.fiap.postech.carrinho.dominio.exception.PedidoNaoEncontradoException;
import br.com.fiap.postech.carrinho.dominio.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class VizualizarPedido {
    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido executa(UsuarioDto usuarioDto, UUID pedidoId) {
        Optional<Pedido> optPedido = pedidoRepository.buscarPorId(pedidoId);
        if(optPedido.isEmpty()) {
            throw new PedidoNaoEncontradoException();
        }
        Pedido pedido = optPedido.get();
        if(!pedido.getIdUsuario().equals(usuarioDto.getId())) {
            throw new PedidoNaoEncontradoException();
        }

        return pedido;
    }
}
