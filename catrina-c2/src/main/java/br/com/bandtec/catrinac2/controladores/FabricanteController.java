package br.com.bandtec.catrinac2.controladores;

import br.com.bandtec.catrinac2.Lista.ListaObj;
import br.com.bandtec.catrinac2.dominios.Fabricante;
import br.com.bandtec.catrinac2.repositorios.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

  @Autowired
  private FabricanteRepository fabricanteRepository;

  @GetMapping
  public ResponseEntity listar() {
    List<Fabricante> listBd = fabricanteRepository.findAll();

    if (listBd.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(listBd);
  }

  @GetMapping("/{id}")
  public ResponseEntity busca(@PathVariable Integer id){
    Optional<Fabricante> optionalFabricante = fabricanteRepository.findById(id);
    return ResponseEntity.of(optionalFabricante);
  }

  @PostMapping
  public ResponseEntity criar(@RequestBody Fabricante fabricante) {
    List<Fabricante> listBd = fabricanteRepository.findAll();

    for (Fabricante f: listBd) {
      if (f.getNome().equals(fabricante.getNome())) {
        return ResponseEntity.ok("Fabricante já existente na nossa base de dados");
      }
    }

    fabricanteRepository.save(fabricante);
    return ResponseEntity.status(201).build();

  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable Integer id, @RequestBody Fabricante fabricante) {
    if (fabricanteRepository.existsById(id)) {
      fabricante.setId(id);
      fabricanteRepository.save(fabricante);
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }


}
