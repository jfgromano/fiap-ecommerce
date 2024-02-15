package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import br.com.fiap.postech.carrinho.dominio.gateway.ItemGateway;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObterItensCarrinho {
    @Autowired
    ItemCarrinhoRepository repo;

    @Autowired
    ItemGateway itemGateway;
    public List<ItemCarrinho> executa(UsuarioDto usuarioDto) {
        List<ItemCarrinho> itens = repo.buscarItensDoCarrinho(usuarioDto.getId());
        for(ItemCarrinho item : itens) {
            itemGateway.atualizarDadosItem(usuarioDto.getToken(), item);
        }
        return itens;
    }
}
