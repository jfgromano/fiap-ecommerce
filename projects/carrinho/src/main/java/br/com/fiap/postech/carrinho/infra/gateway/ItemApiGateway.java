package br.com.fiap.postech.carrinho.infra.gateway;

import br.com.fiap.postech.carrinho.dominio.entidade.ItemCarrinho;
import br.com.fiap.postech.carrinho.dominio.exception.ItemNaoEncontradoException;
import br.com.fiap.postech.carrinho.dominio.gateway.ItemGateway;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
public class ItemApiGateway extends AbstractApiGateway implements ItemGateway {

    @Value("${microservicos.gestao-itens.uri}")
    private String urlGestaoItensMs;

    @Override
    public void atualizarDadosItem(String token, ItemCarrinho item) {
        WebClient client = WebClient.builder().build();
        WebClient.RequestHeadersUriSpec<?> request = client.get();
        adicionarTokenAutenticacao(request, token);
        request.uri(urlGestaoItensMs + "/item/" + item.getIdItem().toString());

        try {
            String json = request.retrieve().bodyToMono(String.class).block();
            JsonObject jsonObject = JsonParser.parseString(json)
                    .getAsJsonObject();
            item.setValorUnitario(jsonObject.get("valor").getAsBigDecimal());
            item.setNome(jsonObject.get("nome").getAsString());
            item.setQuantidadeDisponivel(jsonObject.get("quantidade").getAsInt());
        }catch (WebClientResponseException.NotFound e) {
            throw new ItemNaoEncontradoException();
        }
    }
}
