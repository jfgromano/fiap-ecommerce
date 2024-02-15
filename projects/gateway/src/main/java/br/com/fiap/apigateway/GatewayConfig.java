package br.com.fiap.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayConfig {
    @Value("${microservicos.gestao-itens.uri}")
    private String urlGestaoItensMs;

    @Value("${microservicos.carrinho.uri}")
    private String urlCarrinhoMs;

    @Value("${microservicos.autenticacao.uri}")
    private String urlAutenticacaoMs;

    @Autowired
    private AuthFilter authFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth_ms_autenticar", r -> r
                        .path("/auth/cadastrar", "/auth")
                        .uri(urlAutenticacaoMs))
                .route("auth_ms", r -> r
                        .path("/auth/jwt", "/enderecos/**", "/contatos/**")
                        .filters(f -> f.filter(authFilter))
                        .uri(urlAutenticacaoMs))
                .route("itens_ms", r -> r
                        .path("/item/**")
                        .filters(f -> f.filter(authFilter))
                        .uri(urlGestaoItensMs))
                .route("carrinho_ms", r -> r
                        .path("/carrinho/**", "/pedido/**")
                        .filters(f -> f.filter(authFilter))
                        .uri(urlCarrinhoMs))
                .build();
    }
}