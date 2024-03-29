package br.com.fiap.postech.carrinho.web.autenticacao;

import br.com.fiap.postech.carrinho.dominio.dto.UsuarioDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsuarioAutenticacao implements UserDetails {
    private final UsuarioDto usuarioDto;

    public UsuarioAutenticacao(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UsuarioDto getUsuario() {
        return usuarioDto;
    }
}
