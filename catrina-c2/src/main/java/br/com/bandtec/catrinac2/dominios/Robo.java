package br.com.bandtec.catrinac2.dominios;

import javax.persistence.*;

@Entity
public class Robo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String modelo;
  private Integer capacidadeBateria;

  @ManyToOne(fetch = FetchType.EAGER)
  private Fabricante fabricante;

  public Robo(Integer id, String nome, String modelo, Integer capacidadeBateria) {
    this.id = id;
    this.nome = nome;
    this.modelo = modelo;
    this.capacidadeBateria = capacidadeBateria;
  }

  public Robo() {
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

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Integer getCapacidadeBateria() {
    return capacidadeBateria;
  }

  public void setCapacidadeBateria(Integer capacidadeBateria) {
    this.capacidadeBateria = capacidadeBateria;
  }

  public Fabricante getFabricante() {
    return fabricante;
  }

  public void setFabricante(Fabricante fabricante) {
    this.fabricante = fabricante;
  }
}
