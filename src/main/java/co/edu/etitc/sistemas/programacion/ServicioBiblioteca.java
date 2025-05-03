package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collections;
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

    public ServicioBiblioteca(
            LibroRepositorio libroRepositorio,
            PeriodicoRepositorio periodicoRepositorio,
            ComputadorRepositorio computadorRepositorio) {

        this.libroRepositorio = libroRepositorio;
        this.periodicoRepositorio = periodicoRepositorio;
        this.computadorRepositorio = computadorRepositorio;
    }

    public void agregarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            libroRepositorio.save((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            periodicoRepositorio.save((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            computadorRepositorio.save((Computador) recurso);
        }
    }

    public void eliminarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            libroRepositorio.delete((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            periodicoRepositorio.delete((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            computadorRepositorio.delete((Computador) recurso);
        }
    }

    public List<Recurso> buscaRecursos(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll(libroRepositorio.findByCriteria(criterio));
        resultados.addAll(periodicoRepositorio.findByCriteria(criterio));
        resultados.addAll(computadorRepositorio.findByCriteria(criterio));
        return resultados;
    }

    public List<Recurso> obtenerTodos() {
        return Stream.concat(
                Stream.concat(
                        StreamSupport.stream(libroRepositorio.findAll().spliterator(), false),
                        StreamSupport.stream(periodicoRepositorio.findAll().spliterator(), false)),
                        StreamSupport.stream(computadorRepositorio.findAll().spliterator(), false))
                .collect(Collectors.toList());
    }
}
