package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.entidade.Usuario;
import br.com.fiap.postech.gestaoitens.dominio.exception.ItemNaoEncontradoException;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CriaAtualizaItem {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ValidaPermissoesRecursoAction validaPermissoesRecursoAction;

    @Transactional
    public Item executa(Usuario usuario, Item item) {
        validaPermissoesRecursoAction.executa(usuario);

        if(item.getId() != null){
            Optional<Item> opt = itemRepository.buscaPorIdParaAtualizar(item.getId());
            if(opt.isEmpty()) {
                throw new ItemNaoEncontradoException();
            }

            Item itemEmBanco = opt.get();
            if(item.getQuantidade() != null) {
                itemEmBanco.setQuantidade(item.getQuantidade());
            }
            if(item.getValor() != null) {
                itemEmBanco.setValor(item.getValor());
            }

            item = itemEmBanco;
        }
        return itemRepository.criaOuAtualiza(item);
    }
}
