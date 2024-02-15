package br.com.fiap.postech.gestaoitens.dominio;
import java.util.List;

public record PaginacaoOutput<T>(
        List<T> itens,
        int paginaAtual,
        int totalDePaginas,
        int itensPorPagina
) {
    public PaginacaoOutput(List<T> entidades,
                           int paginaAtual,
                           long totalDeItens,
                           int itensPorPagina) {
        this(
                entidades,
                paginaAtual,
                calcularNumeroDePaginas(totalDeItens, itensPorPagina),
                itensPorPagina
        );
    }

    private static int calcularNumeroDePaginas(long totalDeItens, int itensPorPagina) {
        int paginas = (int) Math.ceil((double)totalDeItens / itensPorPagina);
        if(paginas == 0){
            paginas = 1;
        }
        return paginas;
    }
}