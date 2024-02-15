package br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects;

public enum Sexo {
    MASCULINO("Masculino", "M"),
    FEMININO("Feminino", "F");

    private final String descricao;
    private final String sigla;

    Sexo(String descricao, String sigla) {
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public static Sexo buscarPorSigla(String sigla) {
        if(sigla == null) {
            return null;
        }
        for (Sexo e: Sexo.values()) {
            if(e.sigla.contentEquals(sigla.toUpperCase())) {
                return e;
            }
        }
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }
}
