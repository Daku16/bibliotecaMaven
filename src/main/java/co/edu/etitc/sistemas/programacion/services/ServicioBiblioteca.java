
package co.edu.etitc.sistemas.programacion.services;

import co.edu.etitc.sistemas.programacion.model.Computador;
import co.edu.etitc.sistemas.programacion.model.Libro;
import co.edu.etitc.sistemas.programacion.model.Periodico;
import co.edu.etitc.sistemas.programacion.model.Recurso;
import co.edu.etitc.sistemas.programacion.repositories.ComputadorRepositorio;
import co.edu.etitc.sistemas.programacion.repositories.LibroRepositorio;
import co.edu.etitc.sistemas.programacion.repositories.PeriodicoRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;

@Service
public class ServicioBiblioteca {
    private final LibroRepositorio libroRepositorio;
    private final PeriodicoRepositorio periodicoRepositorio;
    private final ComputadorRepositorio computadorRepositorio;

    public ServicioBiblioteca(LibroRepositorio libroRepositorio, PeriodicoRepositorio periodicoRepositorio, ComputadorRepositorio computadorRepositorio) {
        this.libroRepositorio = libroRepositorio;
        this.periodicoRepositorio = periodicoRepositorio;
        this.computadorRepositorio = computadorRepositorio;
    }

    public void agregarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            this.libroRepositorio.save((Libro)recurso);
        } else if (recurso instanceof Periodico) {
            this.periodicoRepositorio.save((Periodico)recurso);
        } else if (recurso instanceof Computador) {
            this.computadorRepositorio.save((Computador)recurso);
        }

    }

    public boolean eliminarPorTipoEId(String tipo, Integer id) {
        switch (tipo.toLowerCase()) {
            case "libro" -> {
                return (Boolean)this.libroRepositorio.findById(id).map((libro) -> {
                    this.libroRepositorio.delete(libro);
                    return true;
                }).orElse(false);
            }
            case "periodico" -> {
                return (Boolean)this.periodicoRepositorio.findById(id).map((p) -> {
                    this.periodicoRepositorio.delete(p);
                    return true;
                }).orElse(false);
            }
            case "computador" -> {
                return (Boolean)this.computadorRepositorio.findById(id).map((c) -> {
                    this.computadorRepositorio.delete(c);
                    return true;
                }).orElse(false);
            }
            default -> {
                return false;
            }
        }
    }

    public List<Recurso> buscaRecursos(String criterio) {
        List<Recurso> resultados = new ArrayList();
        resultados.addAll(this.libroRepositorio.findByCriteria(criterio));
        resultados.addAll(this.periodicoRepositorio.findByCriteria(criterio));
        resultados.addAll(this.computadorRepositorio.findByCriteria(criterio));
        return resultados;
    }

    public List<Recurso> obtenerTodos() {
        return (List)Stream.concat(Stream.concat(StreamSupport.stream(this.libroRepositorio.findAll().spliterator(), false), StreamSupport.stream(this.periodicoRepositorio.findAll().spliterator(), false)), StreamSupport.stream(this.computadorRepositorio.findAll().spliterator(), false)).collect(Collectors.toList());
    }
}
