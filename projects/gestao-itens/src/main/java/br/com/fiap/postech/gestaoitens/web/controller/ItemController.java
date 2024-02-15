package br.com.fiap.postech.gestaoitens.web.controller;

import br.com.fiap.postech.gestaoitens.aplicacao.CriaAtualizaItem;
import br.com.fiap.postech.gestaoitens.aplicacao.ListarItens;
import br.com.fiap.postech.gestaoitens.aplicacao.ObterItem;
import br.com.fiap.postech.gestaoitens.dominio.PaginacaoOutput;
import br.com.fiap.postech.gestaoitens.dominio.entidade.Item;
import br.com.fiap.postech.gestaoitens.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.gestaoitens.web.form.ItemForm;
import br.com.fiap.postech.gestaoitens.web.form.PatchItemForm;
import br.com.fiap.postech.gestaoitens.web.view.ItemView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private CriaAtualizaItem criaAtualizaItem;

    @Autowired
    private ListarItens listarItens;

    @Autowired
    private ObterItem obterItem;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody ItemForm itemForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Item item = this.criaAtualizaItem.executa(authUser.getUsuario(), itemForm.asItem());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ItemView(item));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") UUID id, @Valid @RequestBody PatchItemForm itemForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Item item = this.criaAtualizaItem.executa(authUser.getUsuario(), itemForm.asItem(id));
        return ResponseEntity.status(HttpStatus.OK).body(new ItemView(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obterItem(@PathVariable("id") UUID id, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Item item = this.obterItem.executa(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ItemView(item));
    }



    @GetMapping
    public ResponseEntity<?> listar(@RequestParam(value = "page", required = false, defaultValue = "0") int page) {
        PaginacaoOutput<Item> retorno = this.listarItens.executa(page, 10);
        PaginacaoOutput<ItemView> view =  new PaginacaoOutput<>(
                retorno.itens().stream().map(e -> new ItemView(e)).collect(Collectors.toList()),
                retorno.paginaAtual(),
                retorno.totalDePaginas(),
                retorno.itensPorPagina()
        );
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }
}
