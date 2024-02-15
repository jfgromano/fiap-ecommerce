package br.com.fiap.postech.pagamento.dominio.dto;

import br.com.fiap.postech.pagamento.dominio.entidade.Cartao;

import java.util.UUID;

public record CartaoDto(String numero, String cvv, TIPO_CARTAO tipo) {
    public Cartao toCartao(UUID idUsuario, String token) {
        return new Cartao(
                idUsuario,
                numero.substring(numero.length() - 4, numero.length()),
                tipo.name(),
                token
        );
    }

    public enum TIPO_CARTAO {DEBITO, CREDITO}
}