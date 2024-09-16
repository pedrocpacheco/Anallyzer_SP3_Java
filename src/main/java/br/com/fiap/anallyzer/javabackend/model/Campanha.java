package br.com.fiap.anallyzer.javabackend.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SP3_CAMPANHA")
public class Campanha {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_campanha")
  private Long id;

  @Column(name = "clicks_efetivos")
  private Long clicksEfetivos;

  public Campanha() {
  }

  public Campanha(Long clicksEfetivos, Empresa empresa) {
    this.clicksEfetivos = clicksEfetivos;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getClicksEfetivos() {
    return clicksEfetivos;
  }

  public void setClicksEfetivos(Long clicksEfetivos) {
    this.clicksEfetivos = clicksEfetivos;
  }

  @Override
  public String toString() {
    return "Campanha{" +
        "id=" + id +
        ", clicksEfetivos=" + clicksEfetivos +
        '}';
  }
}
