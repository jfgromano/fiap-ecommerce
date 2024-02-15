package br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects;

public enum Estado {
    ACRE("AC"),
    ALAGOAS("AL"),
    AMAPA("AP"),
    AMAZONAS("AM"),
    BAHIA("BA"),
    CEARA("CE"),
    ESPIRITO_SANTO("ES"),
    GOIAS("GO"),
    MARANHAO("MA"),
    MATO_GROSSO("MT"),
    MATO_GROSSO_DO_SUL("MS"),
    MINAS_GERAIS("MG"),
    PARA("PA"),
    PARAIBA("PB"),
    PARANA("PR"),
    PERNAMBUCO("PE"),
    PIAUI("PI"),
    RIO_DE_JANEIRO("RJ"),
    RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"),
    RONDONIA("RO"),
    RORAIMA("RR"),
    SANTA_CATARINA("SC"),
    SAO_PAULO("SP"),
    SERGIPE("SE"),
    TOCANTINS("TO");

    private final String sigla;

    Estado(String sigla) {
        this.sigla = sigla;
    }

    public static Estado buscarPorSigla(String sigla) {
        if(sigla == null) {
            return null;
        }
        for (Estado e: Estado.values()) {
            if(e.sigla.contentEquals(sigla.toUpperCase())) {
                return e;
            }
        }
        return null;
    }

    public String getSigla() {
        return sigla;
    }
}
