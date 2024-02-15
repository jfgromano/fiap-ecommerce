package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveItemCarrinho {
    @Autowired
    ItemCarrinhoRepository repo;

    public void executa(UsuarioDto usuarioDto, ItemCarrinho item) {
        repo.removerItem(item.getIdItem(), usuarioDto.getId(), item.getQuantidade());
    }
}
