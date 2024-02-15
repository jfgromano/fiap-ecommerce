package br.com.fiap.postech.carrinho.infra.gateway;

import br.com.fiap.postech.carrinho.dominio.dto.CartaoDto;
import br.com.fiap.postech.carrinho.dominio.gateway.PagamentoGateway;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Component
public class PagamentoApiGateway extends AbstractApiGateway implements PagamentoGateway {

    @Value("${microservicos.pagamento.uri}")
    private String urlPagamentoMs;

    @Override
    public UUID obterToken(String token, CartaoDto cartaoDto) {
        WebClient client = WebClient.builder().build();
        WebClient.RequestBodyUriSpec request = client.post();
        adicionarTokenAutenticacao(request, token);
        request.uri(urlPagamentoMs + "/pagamento/tokenize");
        request.bodyValue(cartaoDto);
        String json = request.retrieve().bodyToMono(String.class).block();
        JsonObject jsonObject = JsonParser.parseString(json)
                .getAsJsonObject();
        return UUID.fromString(jsonObject.get("token").getAsString());
    }
}
