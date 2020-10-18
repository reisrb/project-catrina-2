package br.com.bandtec.catrinac2.controladores;

import br.com.bandtec.catrinac2.dominios.Robo;
import br.com.bandtec.catrinac2.repositorios.FabricanteRepository;
import br.com.bandtec.catrinac2.repositorios.RoboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/robos")
public class RoboController {

  @Autowired
  private RoboRepository roboRepository;

  @Autowired
  private FabricanteRepository fabricanteRepository;

  @GetMapping
  public ResponseEntity listar(){
    List<Robo> listBd = roboRepository.findAll();

    if(listBd.isEmpty()){
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listBd);
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

  @DeleteMapping("/{id}")
  public ResponseEntity deletar(@PathVariable Integer id) {
    Optional<Robo> optionalRobo = roboRepository.findById(id);

    if (optionalRobo.isPresent()){
      Robo robo = optionalRobo.get();
      roboRepository.delete(robo);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.of(optionalRobo);
  }

}
