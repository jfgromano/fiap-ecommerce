package br.com.fiap.postech.carrinho.aplicacao;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import br.com.fiap.postech.carrinho.dominio.exception.ItemNaoEncontradoException;
import br.com.fiap.postech.carrinho.dominio.exception.LimiteDeQuantidadeException;
import br.com.fiap.postech.carrinho.dominio.gateway.ItemGateway;
import br.com.fiap.postech.carrinho.dominio.repositorio.ItemCarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionaItemCarrinho {
    @Autowired
    ItemCarrinhoRepository repo;
    @Autowired
    ItemGateway itemGateway;
    public void executa(UsuarioDto usuarioDto, ItemCarrinho item) {
        //Solicitacao para o servico de gestao de itens que atualiza
        // a quantidade disponivel do item
        itemGateway.atualizarDadosItem(usuarioDto.getToken(), item);

        if(item.getNome() == null) {
            throw new ItemNaoEncontradoException();
        }

        if(item.getQuantidade() > item.getQuantidadeDisponivel()) {
            throw new LimiteDeQuantidadeException();
        }

        repo.adicionarItem(item.getIdItem(), usuarioDto.getId(), item.getQuantidade());
    }
}
