package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.PaginacaoOutput;
import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarItens {
    @Autowired
    private ItemRepository itemRepository;
    public PaginacaoOutput<Item> executa(int pagina, int limit) {
        return new PaginacaoOutput<>(
                this.itemRepository.listarTodos(pagina, limit),
                pagina,
                this.itemRepository.count(),
                limit
        );
    }
}
