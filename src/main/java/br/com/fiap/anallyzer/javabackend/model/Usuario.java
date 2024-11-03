package br.com.fiap.anallyzer.javabackend.model;

import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // ID do usuário

  private String username; // Nome de usuário

  private String password; // Senha do usuário

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING) // Armazena os perfis como String
  private Set<Perfil> perfis; // Perfis do usuário

  // Construtor padrão

  public Usuario(String string, String string2, Set<Perfil> set) {
    this.username = string;
    this.password = string2;
    this.perfis = set;
  }

  public Usuario() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Perfil> getPerfis() {
    return perfis;
  }

  public void setPerfis(Set<Perfil> perfis) {
    this.perfis = perfis;
  }
}