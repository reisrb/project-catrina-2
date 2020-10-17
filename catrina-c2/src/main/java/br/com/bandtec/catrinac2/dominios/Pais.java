package br.com.bandtec.catrinac2.dominios;

import javax.persistence.*;

@Entity
public class Pais {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  public Pais(Integer id, String nome) {
    this.id = id;
    this.nome = nome;
  }

  public Pais() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
