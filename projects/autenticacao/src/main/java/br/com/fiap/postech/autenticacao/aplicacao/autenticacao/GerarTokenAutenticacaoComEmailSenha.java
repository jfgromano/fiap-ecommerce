package br.com.fiap.postech.autenticacao.aplicacao.autenticacao;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class GerarTokenAutenticacaoComEmailSenha {
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepo;

    public String executa(Usuario usuario) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha()));
        Usuario usuarioEmBanco  = usuarioRepo.buscaPorEmail(usuario.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        return jwtTokenService.gerarToken(usuarioEmBanco);
    }
}
