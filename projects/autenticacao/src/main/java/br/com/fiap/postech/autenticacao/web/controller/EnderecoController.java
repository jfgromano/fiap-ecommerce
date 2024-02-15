package br.com.fiap.postech.autenticacao.web.controller;

import br.com.fiap.postech.autenticacao.aplicacao.endereco.CriaAtualizaEndereco;
import br.com.fiap.postech.autenticacao.aplicacao.endereco.ObterEnderecoUsuario;
import br.com.fiap.postech.autenticacao.dominio.entidade.Endereco;
import br.com.fiap.postech.autenticacao.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.autenticacao.web.form.EnderecoForm;
import br.com.fiap.postech.autenticacao.web.view.EnderecoView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/enderecos")

public class EnderecoController {
    @Autowired
    private CriaAtualizaEndereco criaAtualizaEndereco;

    @Autowired
    private ObterEnderecoUsuario obterEndereco;

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable("id") UUID id, @Valid @RequestBody EnderecoForm enderecoForm, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Endereco endereco = this.criaAtualizaEndereco.executa(authUser.getUsuario(), enderecoForm.asEndereco(), id);
        EnderecoView view = new EnderecoView(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado().getSigla()
        );
        return ResponseEntity.status(HttpStatus.OK).body(view);
    }

    @GetMapping
    public ResponseEntity<?> obter(@AuthenticationPrincipal UsuarioAutenticacao authUser) {
        Endereco retorno = this.obterEndereco.executa(authUser.getUsuario());
        return ResponseEntity.status(HttpStatus.OK).body(new EnderecoView(retorno));
    }
}
