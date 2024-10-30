package br.com.fiap.anallyzer.javabackend.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.anallyzer.javabackend.model.Perfil;
import br.com.fiap.anallyzer.javabackend.model.Usuario;
import br.com.fiap.anallyzer.javabackend.repository.UsuarioRepository;

@Configuration
public class DataLoader {

  @Bean
  CommandLineRunner initData(UsuarioRepository usuarioRepository) {
    return args -> {
      if (usuarioRepository.findByUsername("admin").isEmpty()) {
        Usuario admin = new Usuario("admin", "admin123", Set.of(Perfil.ROLE_ADMIN));
        usuarioRepository.save(admin);
      }
    };
  }
}