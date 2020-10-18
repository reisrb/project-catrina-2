package br.com.bandtec.catrinac2.repositorios;

import br.com.bandtec.catrinac2.dominios.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
