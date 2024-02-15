package br.com.fiap.apigateway;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

/**
 * Aqui estou validando apenas se a request tem o jwt,
 * caso nao tenha eu nem envio para o serviço de autenticação para evitar sobrecarga desnecessaria
 */
@RefreshScope
@Component
public class AuthFilter implements GatewayFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        List<String> authHeader = request.getHeaders().get(HttpHeaders.AUTHORIZATION);

        //Nao possui header de autenticacao
        if(authHeader.size() == 0) {
            return finish(exchange, HttpStatus.FORBIDDEN);
        }

        //Nao inicia com Bearer
        String bearer = authHeader.getFirst();
        if(!bearer.startsWith("Bearer ")) {
            return finish(exchange, HttpStatus.FORBIDDEN);
        }

        //Esta expirado
        String token = bearer.substring(7);
        DecodedJWT decoded = JWT.decode(token);
        Date expiresAt = decoded.getExpiresAt();
        if(expiresAt.before(new Date())) {
            return finish(exchange, HttpStatus.FORBIDDEN);
        }

        return chain.filter(exchange);
    }

    private Mono<Void> finish(ServerWebExchange exchange, HttpStatus status) {
        exchange.getResponse().setStatusCode(status);
        return exchange.getResponse().setComplete();
    }
}
