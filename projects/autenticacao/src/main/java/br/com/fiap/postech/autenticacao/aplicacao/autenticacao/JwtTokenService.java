package br.com.fiap.postech.autenticacao.aplicacao.autenticacao;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class JwtTokenService {
    private static final Duration JWT_TOKEN_VALIDITY = Duration.ofMinutes(20);
    private final Algorithm hmac512;
    private final JWTVerifier verifier;

    public JwtTokenService(@Value("${jwt.secret}") final String secret) {
        this.hmac512 = Algorithm.HMAC512(secret);
        this.verifier = JWT.require(this.hmac512).build();
    }

    public String gerarToken(final Usuario usuario) {
        final Instant now = Instant.now();
        return JWT.create()
                .withSubject(usuario.getEmail())
                .withIssuer("tech-challenge")
                .withIssuedAt(now)
                .withExpiresAt(now.plusMillis(JWT_TOKEN_VALIDITY.toMillis()))
                .sign(this.hmac512);
    }

    public String validarTokenObtendoEmailUsuario(final String token) {
        return verifier.verify(token).getSubject();
    }
}
