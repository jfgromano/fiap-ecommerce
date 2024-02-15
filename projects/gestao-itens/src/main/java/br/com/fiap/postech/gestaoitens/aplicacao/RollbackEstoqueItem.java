package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.dto.ItensDoPedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.dto.PedidoDto;
import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RollbackEstoqueItem {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void executa(PedidoDto pedido) {
        for(ItensDoPedidoDto item : pedido.itens()) {
            Optional<Item> opt = itemRepository.buscaPorIdParaAtualizar(item.itemId());
            if(opt.isEmpty()) {
                continue;
            }
            Item itemEmBanco = opt.get();
            Integer quantidadeAtual = itemEmBanco.getQuantidade();
            itemEmBanco.setQuantidade(quantidadeAtual + item.quantidade());
        }
    }
}
