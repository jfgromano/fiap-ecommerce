package br.com.fiap.postech.carrinho.infra.gateway;

import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import br.com.fiap.postech.carrinho.dominio.gateway.RecuperarUsuarioAutenticadoGateway;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class RecuperarUsuarioAutenticadoApiGateway extends AbstractApiGateway implements RecuperarUsuarioAutenticadoGateway {

    @Value("${microservicos.autenticacao.uri}")
    private String urlAutenticacaoMs;

    @Override
    public UsuarioDto getUsuario(String token) {
        WebClient client = WebClient.builder().build();
        WebClient.RequestHeadersUriSpec<?> request = client.post();
        adicionarTokenAutenticacao(request, token);
        request.uri(urlAutenticacaoMs + "/auth/jwt");
        Mono<String> response = request.retrieve().bodyToMono(String.class);
        return parseUsuario(token ,response.block());
    }

    private UsuarioDto parseUsuario(String token, String json) {
        JsonObject jsonObject = JsonParser.parseString(json)
                .getAsJsonObject();
        UUID uuid = UUID.fromString(jsonObject.getAsJsonObject("usuario").get("id").getAsString());
        return new UsuarioDto(uuid, token);
    }
}
