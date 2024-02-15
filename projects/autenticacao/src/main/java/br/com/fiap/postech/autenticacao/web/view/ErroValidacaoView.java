package br.com.fiap.postech.autenticacao.web.view;

import java.util.List;
import java.util.Map;

public record ErroValidacaoView(Map<String, List<String>> campos) {

}
