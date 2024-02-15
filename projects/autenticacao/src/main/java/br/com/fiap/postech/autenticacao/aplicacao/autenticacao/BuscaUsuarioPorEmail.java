package br.com.fiap.postech.autenticacao.aplicacao.autenticacao;

import br.com.fiap.postech.autenticacao.dominio.entidade.Usuario;
import br.com.fiap.postech.autenticacao.dominio.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaUsuarioPorEmail {
    @Autowired
    private UsuarioRepository usuarioRepo;

    public Optional<Usuario> executa(String email) {
        return usuarioRepo.buscaPorEmail(email);
    }
}
