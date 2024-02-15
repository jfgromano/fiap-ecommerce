package br.com.fiap.postech.carrinho.web.controller;

import br.com.fiap.postech.carrinho.aplicacao.AdicionaItemCarrinho;
import br.com.fiap.postech.carrinho.aplicacao.GerarPedido;
import br.com.fiap.postech.carrinho.aplicacao.ObterItensCarrinho;
import br.com.fiap.postech.carrinho.aplicacao.RemoveItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.carrinho.web.form.ItemForm;
import br.com.fiap.postech.carrinho.web.view.CarrinhoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private AdicionaItemCarrinho adicionaItemCarrinho;
    @Autowired
    private RemoveItemCarrinho removeItemCarrinho;
    @Autowired
    private ObterItensCarrinho obterItensCarrinho;

    @Autowired
    private GerarPedido gerarPedido;

    @PostMapping("/{idItem}/add")
    public ResponseEntity<?> adicionarItem(@PathVariable("idItem") UUID idItem, @Valid @RequestBody ItemForm itemForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.adicionaItemCarrinho.executa(authUser.getUsuario(), itemForm.asItem(idItem, authUser.getUsuario().getId()));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{idItem}/remove")
    public ResponseEntity<?> removerItem(@PathVariable("idItem") UUID idItem, @Valid @RequestBody ItemForm itemForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        this.removeItemCarrinho.executa(authUser.getUsuario(), itemForm.asItem(idItem, authUser.getUsuario().getId()));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<?> carrinho(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        List<ItemCarrinho> itens = this.obterItensCarrinho.executa(authUser.getUsuario());
        return ResponseEntity.status(HttpStatus.OK).body(CarrinhoView.fromItensCarrinho(itens));
    }
}
