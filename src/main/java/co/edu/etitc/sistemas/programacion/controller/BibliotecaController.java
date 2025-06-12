//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package co.edu.etitc.sistemas.programacion.controller;

import co.edu.etitc.sistemas.programacion.model.Computador;
import co.edu.etitc.sistemas.programacion.model.Libro;
import co.edu.etitc.sistemas.programacion.model.Periodico;
import co.edu.etitc.sistemas.programacion.model.Recurso;
import co.edu.etitc.sistemas.programacion.services.ServicioBiblioteca;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/"})
public class BibliotecaController {
    @Autowired
    private ServicioBiblioteca servicioBiblioteca;

    public BibliotecaController() {
    }

    @GetMapping(
            path = {"/recursos"},
            produces = {"application/json"}
    )
    public List<Recurso> obtenerRecursos() {
        return this.servicioBiblioteca.obtenerTodos();
    }

    @GetMapping(
            path = {"/recursos/buscar"},
            produces = {"application/json"}
    )
    public List<Recurso> buscarRecursos(@RequestParam("criterio") String criterio) {
        return this.servicioBiblioteca.buscaRecursos(criterio);
    }

    @PostMapping({"/libro"})
    public ResponseEntity<Void> agregarLibro(@RequestBody Libro libro) {
        this.servicioBiblioteca.agregarRecurso(libro);
        return ResponseEntity.ok().build();
    }

    @PostMapping({"/periodico"})
    public ResponseEntity<Void> agregarPeriodico(@RequestBody Periodico periodico) {
        this.servicioBiblioteca.agregarRecurso(periodico);
        return ResponseEntity.ok().build();
    }

    @PostMapping({"/computador"})
    public ResponseEntity<Void> agregarComputador(@RequestBody Computador computador) {
        this.servicioBiblioteca.agregarRecurso(computador);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/recursos/{tipo}/{id}"})
    public ResponseEntity<Void> eliminarPorTipoEId(@PathVariable(name = "tipo") String tipo, @PathVariable(name = "id") Integer id) {
        boolean eliminado = this.servicioBiblioteca.eliminarPorTipoEId(tipo, id);
        return eliminado ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
