package br.com.fiap.postech.carrinho.dominio.dto;

public record CartaoDto(String numero, String cvv, TIPO_CARTAO tipo) {
    public enum TIPO_CARTAO {DEBITO, CREDITO}
}
