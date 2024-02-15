package br.com.fiap.postech.carrinho.web.controller;

import br.com.fiap.postech.carrinho.aplicacao.*;
import br.com.fiap.postech.carrinho.dominio.entidade.Pedido;
import br.com.fiap.postech.carrinho.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.carrinho.web.form.CartaoForm;
import br.com.fiap.postech.carrinho.web.view.PedidoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private GerarPedido gerarPedido;
    @Autowired
    private VizualizarPedido vizualizarPedido;
    @GetMapping(path = "/{idPedido}")
    public ResponseEntity<PedidoView> getPedido(@AuthenticationPrincipal UsuarioAutenticacao authUser, @PathVariable UUID idPedido) {
        Pedido pedido = vizualizarPedido.executa(authUser.getUsuario(), idPedido);
        return ResponseEntity.status(HttpStatus.OK).body(PedidoView.fromPedido(pedido));
    }
    @PostMapping
    public ResponseEntity<?> gerarPedido(@Valid @RequestBody CartaoForm cartaoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Pedido pedido = gerarPedido.executa(authUser.getUsuario(), cartaoForm.toCartao());
        return ResponseEntity.status(HttpStatus.OK).body(PedidoView.fromPedido(pedido));
    }
}
