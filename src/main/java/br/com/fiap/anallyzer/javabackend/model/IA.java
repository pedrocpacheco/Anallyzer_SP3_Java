package br.com.fiap.anallyzer.javabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SP3_IA")
public class IA {

  public IA() {
  }

  public IA(String descricaoLeitura, Resultado resultado) {
    this.descricaoLeitura = descricaoLeitura;
    this.resultado = resultado;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String descricaoLeitura;

  @Enumerated
  private Resultado resultado;

  public String getDescricaoLeitura() {
    return descricaoLeitura;
  }

  public void setDescricaoLeitura(String descricaoLeitura) {
    this.descricaoLeitura = descricaoLeitura;
  }

  public Resultado getResultado() {
    return resultado;
  }

  public void setResultado(Resultado resultado) {
    this.resultado = resultado;
  }

}
