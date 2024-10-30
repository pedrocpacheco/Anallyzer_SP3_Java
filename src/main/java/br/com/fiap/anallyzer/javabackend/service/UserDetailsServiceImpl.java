package br.com.fiap.anallyzer.javabackend.service;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.anallyzer.javabackend.model.Usuario;
import br.com.fiap.anallyzer.javabackend.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

    var authorities = usuario.getPerfis().stream()
        .map(perfil -> new SimpleGrantedAuthority("ROLE_" + perfil.name()))
        .collect(Collectors.toList());

    return new User(usuario.getUsername(), usuario.getPassword(), authorities);
  }
}
