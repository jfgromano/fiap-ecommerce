package br.com.fiap.postech.gestaoitens.aplicacao;

import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.dominio.exception.ItemNaoEncontradoException;
import br.com.fiap.postech.gestaoitens.dominio.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ObterItem {
    @Autowired
    private ItemRepository itemRepository;

    public Item executa(UUID id) {
        Optional<Item> opt = itemRepository.buscaPorId(id);
        if(opt.isEmpty()) {
            throw new ItemNaoEncontradoException();
        }
        return opt.get();
    }
}
