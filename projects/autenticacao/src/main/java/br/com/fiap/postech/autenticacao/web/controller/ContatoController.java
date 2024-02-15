package br.com.fiap.postech.autenticacao.web.controller;

import br.com.fiap.postech.autenticacao.aplicacao.contato.CriaAtualizaContato;
import br.com.fiap.postech.autenticacao.aplicacao.contato.ObterContatoUsuario;
import br.com.fiap.postech.autenticacao.dominio.entidade.Contato;
import br.com.fiap.postech.autenticacao.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.autenticacao.web.form.ContatoForm;
import br.com.fiap.postech.autenticacao.web.view.ContatoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/contatos")

public class ContatoController {
    @Autowired
    private CriaAtualizaContato criaAtualizaContato;

    @Autowired
    private ObterContatoUsuario obterContato;

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") UUID id, @Valid @RequestBody ContatoForm contatoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Contato contato = this.criaAtualizaContato.executa(authUser.getUsuario(), contatoForm.asContato(), id);
        ContatoView view = new ContatoView(
                contato.getId(),
                contato.getEmail(),
                contato.getNumeroCelular()
        );
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

    @GetMapping
    public ResponseEntity<?> obter(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Contato retorno = this.obterContato.executa(authUser.getUsuario());
        return ResponseEntity.status(HttpStatus.OK).body(new ContatoView(retorno));
    }
}
