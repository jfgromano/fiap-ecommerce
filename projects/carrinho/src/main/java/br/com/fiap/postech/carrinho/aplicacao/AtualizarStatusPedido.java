package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;
import br.com.fiap.postech.carrinho.dominio.enums.StatusPedido;
import br.com.fiap.postech.carrinho.dominio.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarStatusPedido {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void executa(UUID pedidoId, StatusPedido status) {
        Optional<Pedido> pedido = pedidoRepository.buscarPorId(pedidoId);
        if(pedido.isEmpty()) {
            return;
        }

        try {
            pedido.get().setStatus(status);
        }catch (Exception e) {
            e.printStackTrace();
        }

        pedidoRepository.salvarAtualizar(pedido.get());
    }
}
