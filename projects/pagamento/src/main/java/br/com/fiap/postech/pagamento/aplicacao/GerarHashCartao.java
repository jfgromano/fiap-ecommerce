package br.com.fiap.postech.pagamento.aplicacao;

import br.com.fiap.postech.pagamento.dominio.dto.CartaoDto;
import br.com.fiap.postech.pagamento.dominio.entidade.Cartao;
import br.com.fiap.postech.pagamento.dominio.entidade.Usuario;
import br.com.fiap.postech.pagamento.dominio.exception.DominioException;
import br.com.fiap.postech.pagamento.dominio.repositorio.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.util.Optional;
import java.util.UUID;

@SuppressWarnings("OptionalGetWithoutIsPresent")
@Service
public class GerarHashCartao {
    @Autowired
    private CartaoRepository cartaoRepository;

    public UUID executa(Usuario usuario, CartaoDto cartaoDto) {
        StringBuilder key = new StringBuilder()
                .append(usuario.getId().toString()).append("-")
                .append(cartaoDto.cvv()).append("-")
                .append(cartaoDto.numero()).append("-")
                .append(cartaoDto.tipo().name());

        String token = gerarToken(key.toString());
        Optional<Cartao> optCartao = this.cartaoRepository.buscarPorToken(token);
        Cartao cartao = optCartao.orElseGet(() -> this.cartaoRepository.salvar(cartaoDto.toCartao(usuario.getId(), token)));
        return cartao.getId();
    }

    private String gerarToken(String key) {
        try {
            byte[] message = key.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(message);
            byte[] bytes = messageDigest.digest();

            StringBuilder out = new StringBuilder();
            for (byte b : bytes) {
                out.append(String.format("%02X", b));
            }
            return out.toString();
        }catch (Exception e) {
            throw new DominioException("Falha ao gerar hash do cartao");
        }
    }
}
