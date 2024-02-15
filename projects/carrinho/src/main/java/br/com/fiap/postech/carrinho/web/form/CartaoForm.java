package br.com.fiap.postech.carrinho.web.form;

import br.com.fiap.postech.carrinho.dominio.dto.CartaoDto;
import br.com.fiap.postech.carrinho.web.validacoes.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CartaoForm(
        @NotBlank
        String numero,

        @NotBlank
        String cvv,

        @NotNull
        @ValidEnum(enumClass = CartaoDto.TIPO_CARTAO.class)
        String tipo
) {
    public CartaoDto toCartao() {
        return new CartaoDto(
                this.numero,
                this.cvv,
                CartaoDto.TIPO_CARTAO.valueOf(this.tipo)
        );
    }
}
