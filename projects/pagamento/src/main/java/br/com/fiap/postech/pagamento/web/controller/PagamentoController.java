package br.com.fiap.postech.pagamento.web.controller;

import br.com.fiap.postech.pagamento.aplicacao.GerarHashCartao;
import br.com.fiap.postech.pagamento.dominio.dto.CartaoDto;
import br.com.fiap.postech.pagamento.web.autenticacao.UsuarioAutenticacao;
import br.com.fiap.postech.pagamento.web.view.TokenizeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private GerarHashCartao gerarHashCartao;

    @PostMapping(path = "/tokenize")
    public ResponseEntity<?> tokenize(@RequestBody CartaoDto cartaoDto, @AuthenticationPrincipal UsuarioAutenticacao authUser) {
        UUID id = gerarHashCartao.executa(authUser.getUsuario(), cartaoDto);
        return ResponseEntity.status(HttpStatus.OK).body(new TokenizeView(id));
    }
}
