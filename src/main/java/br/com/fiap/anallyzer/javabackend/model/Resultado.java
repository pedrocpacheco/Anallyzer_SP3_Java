package br.com.fiap.anallyzer.javabackend.model;

public enum Resultado {

  SUCESSO("Sucesso"),
  FALHA("Falha"),
  INCERTO("Incerto");

  private final String descricao;

  Resultado(String descricao) {
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }
}
