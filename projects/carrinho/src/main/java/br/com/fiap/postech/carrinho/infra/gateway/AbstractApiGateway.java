package br.com.fiap.postech.carrinho.infra.gateway;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersUriSpec;

@Component
public abstract class AbstractApiGateway {
    protected void adicionarTokenAutenticacao(RequestHeadersUriSpec<?> request, String token) {
        request.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    }
}
