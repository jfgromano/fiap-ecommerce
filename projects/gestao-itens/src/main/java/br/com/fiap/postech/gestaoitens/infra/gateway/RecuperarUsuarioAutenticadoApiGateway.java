package br.com.fiap.postech.gestaoitens.infra.gateway;


import br.com.fiap.postech.gestaoitens.dominio.entidade.Usuario;
import br.com.fiap.postech.gestaoitens.dominio.gateway.RecuperarUsuarioAutenticadoGateway;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class RecuperarUsuarioAutenticadoApiGateway implements RecuperarUsuarioAutenticadoGateway {

    @Value("${microservicos.autenticacao.uri}")
    private String urlAutenticacaoMs;

    @Override
    public Usuario getUsuario(String token) {
        WebClient client = WebClient.builder().build();
        WebClient.RequestHeadersUriSpec<?> request = client.post();
        request.header(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        request.uri(urlAutenticacaoMs + "/auth/jwt");
        Mono<String> response = request.retrieve().bodyToMono(String.class);
        return parseUsuario(response.block());
    }

    private Usuario parseUsuario(String json) {
        JsonObject jsonObject = JsonParser.parseString(json)
                .getAsJsonObject();
        JsonObject usuarioObject = jsonObject.getAsJsonObject("usuario");
        UUID uuid = UUID.fromString(usuarioObject.get("id").getAsString());
        boolean admin = usuarioObject.get("admin").getAsBoolean();
        return new Usuario(uuid, admin);
    }
}
