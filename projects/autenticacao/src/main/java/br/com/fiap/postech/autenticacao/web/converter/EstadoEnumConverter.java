package br.com.fiap.postech.autenticacao.web.converter;

import br.com.fiap.postech.autenticacao.dominio.entidade.valueobjects.Estado;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EstadoEnumConverter implements Converter<String, Estado> {
    @Override
    public Estado convert(String value) {
        try {
            return Estado.valueOf(value.toUpperCase());
        }catch (Exception e){}
        return Estado.buscarPorSigla(value);
    }
}