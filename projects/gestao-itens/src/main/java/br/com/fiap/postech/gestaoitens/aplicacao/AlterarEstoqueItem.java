package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.dto.FalhaPedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.dto.ItensDoPedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.gateway.LiberarPedidoParaPagamentoGateway;
import br.com.fiap.postech.gestaoitens.dominio.gateway.NotificarErroPedidoGateway;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
public class AlterarEstoqueItem {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private LiberarPedidoParaPagamentoGateway liberarPedidoParaPagamentoGateway;

    @Autowired
    private NotificarErroPedidoGateway notificarErroPedidoGateway;

    @Transactional
    public void executa(PedidoDto pedido) {
        Map<UUID, Integer> itensSemEstoque = new HashMap<>();
        for(ItensDoPedidoDto item : pedido.itens()) {
            Optional<Item> opt = itemRepository.buscaPorIdParaAtualizar(item.itemId());
            if(opt.isEmpty()) {
                itensSemEstoque.put(item.itemId(), 0);
                continue;
            }
            Item itemEmBanco = opt.get();
            Integer quantidadeAtual = itemEmBanco.getQuantidade();
            itemEmBanco.setQuantidade(quantidadeAtual - item.quantidade());
            if(itemEmBanco.getQuantidade() < 0) {
                itensSemEstoque.put(item.itemId(), quantidadeAtual);
            }
        }

        if(itensSemEstoque.isEmpty()) {
            liberarPedidoParaPagamentoGateway.executa(pedido);
        }else {
            notificarErroPedidoGateway.executa(FalhaPedidoDto.estoque(pedido, itensSemEstoque));
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
