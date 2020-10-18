package br.com.bandtec.catrinac2.controladores;

import br.com.bandtec.catrinac2.dominios.Pais;
import br.com.bandtec.catrinac2.repositorios.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pais")
public class PaisController {

  private PaisRepository paisRepository;

  @GetMapping
  private ResponseEntity listar(){
    List<Pais> listBd = paisRepository.findAll();

    if(listBd.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listBd);
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

  @DeleteMapping("/{id}")
  public ResponseEntity deletar(@PathVariable Integer id) {
    Optional<Pais> optionalRobo = paisRepository.findById(id);

    if (optionalRobo.isPresent()){
      Pais pais = optionalRobo.get();
      paisRepository.delete(pais);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.of(optionalRobo);
  }

}
