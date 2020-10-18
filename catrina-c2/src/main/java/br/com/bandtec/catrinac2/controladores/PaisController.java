package br.com.bandtec.catrinac2.controladores;

import br.com.bandtec.catrinac2.dominios.Pais;
import br.com.bandtec.catrinac2.dominios.Robo;
import br.com.bandtec.catrinac2.repositorios.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisController {

  @Autowired
  private PaisRepository paisRepository;

  @GetMapping
  private ResponseEntity listar() {
    List<Pais> listBd = paisRepository.findAll();

    if (listBd.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listBd);
  }

  @GetMapping("/{id}")
  public ResponseEntity busca(@PathVariable Integer id){
    if(paisRepository.existsById(id)){
      Optional<Pais> optionalPais = paisRepository.findById(id);
      return ResponseEntity.ok(optionalPais);
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity criar(@RequestBody Pais pais) {
    List<Pais> listBd = paisRepository.findAll();

    for (Pais p : listBd) {
      if (p.getNome().equals(pais.getNome())) {
        return ResponseEntity.ok("Pais já existente na nossa base de dados");
      }
    }

    paisRepository.save(pais);
    return ResponseEntity.status(201).build();

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Pais pais) {
    if (paisRepository.existsById(id)) {
      pais.setId(id);
      paisRepository.save(pais);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

}
