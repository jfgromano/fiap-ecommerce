package br.com.fiap.postech.autenticacao.web.controller;

import br.com.fiap.postech.autenticacao.aplicacao.autenticacao.GerarTokenAutenticacaoComEmailSenha;
import br.com.fiap.postech.autenticacao.aplicacao.autenticacao.CriaUsuarioApi;
import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.autenticacao.web.form.AutenticacaoForm;
import br.com.fiap.postech.autenticacao.web.form.UsuarioForm;
import br.com.fiap.postech.autenticacao.web.view.AutenticacaoView;
import br.com.fiap.postech.autenticacao.web.view.UsuarioCompletoView;
import br.com.fiap.postech.autenticacao.web.view.UsuarioView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private CriaUsuarioApi criaUsuarioApi;
    @Autowired
    private GerarTokenAutenticacaoComEmailSenha gerarTokenAutenticacaoComEmailSenha;
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@Valid @RequestBody UsuarioForm usuarioForm) {
        Usuario usuario = this.criaUsuarioApi.executa(usuarioForm.asUsuario());
        return ResponseEntity.status(HttpStatus.CREATED).body(new UsuarioView(usuario));
    }

    @PostMapping("/jwt")
    public ResponseEntity<?> validarToken(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        return ResponseEntity.status(HttpStatus.OK).body(new UsuarioCompletoView(authUser.getUsuario()));
    }

    @PostMapping()
    public ResponseEntity<?> autenticar(@Valid @RequestBody AutenticacaoForm authForm) {
        String jwt = this.gerarTokenAutenticacaoComEmailSenha.executa(authForm.asUsuario());
        return ResponseEntity.status(HttpStatus.CREATED).body(new AutenticacaoView(jwt));
    }
}
