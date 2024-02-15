package br.com.fiap.postech.autenticacao.web;

import br.com.fiap.postech.autenticacao.web.converter.EstadoEnumConverter;
import br.com.fiap.postech.autenticacao.web.converter.SexoEnumConverter;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addFormatters(final FormatterRegistry registry) {

        ApplicationConversionService.configure(registry);
        registry.addConverter(new SexoEnumConverter());
        registry.addConverter(new EstadoEnumConverter());
    }
}