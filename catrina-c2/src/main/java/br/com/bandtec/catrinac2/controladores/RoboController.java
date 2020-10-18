package br.com.bandtec.catrinac2.controladores;

import br.com.bandtec.catrinac2.dominios.Fabricante;
import br.com.bandtec.catrinac2.dominios.Robo;
import br.com.bandtec.catrinac2.repositorios.FabricanteRepository;
import br.com.bandtec.catrinac2.repositorios.RoboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/robos")
public class RoboController {

  @Autowired
  private RoboRepository roboRepository;

  @GetMapping
  public ResponseEntity listar() {
    List<Robo> listBd = roboRepository.findAll();

    if (listBd.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listBd);
  }

  @GetMapping("/{id}")
  public ResponseEntity busca(@PathVariable Integer id){
    if(roboRepository.existsById(id)){
      Optional<Robo> optionalRobo = roboRepository.findById(id);
      return ResponseEntity.ok(optionalRobo);
    }

    return ResponseEntity.notFound().build();
  }


  @PostMapping
  public ResponseEntity criar(@RequestBody Robo robo) {
    List<Robo> listBd = roboRepository.findAll();

    for (Robo r : listBd) {
      if (r.getModelo().equals(robo.getModelo())) {
        return ResponseEntity.ok("Modelo já existente na nossa base de dados");
      }
    }

    roboRepository.save(robo);
    return ResponseEntity.status(201).build();

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Robo robo) {
    if (roboRepository.existsById(id)) {
      robo.setId(id);
      roboRepository.save(robo);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

}
