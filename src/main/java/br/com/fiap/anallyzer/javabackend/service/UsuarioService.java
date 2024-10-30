package br.com.fiap.anallyzer.javabackend.service;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.javabackend.model.Perfil;
import br.com.fiap.anallyzer.javabackend.model.Usuario;
import br.com.fiap.anallyzer.javabackend.repository.UsuarioRepository;

@Service
public class UsuarioService {

  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder;

  public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public Usuario cadastrarUsuario(String username, String password, Set<Perfil> perfis) {
    Usuario usuario = new Usuario();
    usuario.setUsername(username);
    usuario.setPassword(passwordEncoder.encode(password)); // Codifica a senha
    usuario.setPerfis(perfis); // Define os perfis

    return usuarioRepository.save(usuario); // Salva no banco
  }
}
