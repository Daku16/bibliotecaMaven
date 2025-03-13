package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioBiblioteca {

    private final Repositorio<Libro> libroRepositorio;
    private final Repositorio<Periodico> periodicoRepositorio;
    private final Repositorio<Computador> computadorRepositorio;

    @Autowired
    public ServicioBiblioteca(
            Repositorio<Libro> libroRepositorio,
            Repositorio<Periodico> periodicoRepositorio,
            Repositorio<Computador> computadorRepositorio) {

        this.libroRepositorio = libroRepositorio;
        this.periodicoRepositorio = periodicoRepositorio;
        this.computadorRepositorio = computadorRepositorio;
    }

    public void agregarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            libroRepositorio.agregar((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            periodicoRepositorio.agregar((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            computadorRepositorio.agregar((Computador) recurso);
        }
    }

    public void eliminarRecurso(Recurso recurso) {
        if (recurso instanceof Libro) {
            libroRepositorio.eliminar((Libro) recurso);
        } else if (recurso instanceof Periodico) {
            periodicoRepositorio.eliminar((Periodico) recurso);
        } else if (recurso instanceof Computador) {
            computadorRepositorio.eliminar((Computador) recurso);
        }
    }

    public List<Recurso> buscaRecursos(String criterio) {
        List<Recurso> resultados = new ArrayList<>();
        resultados.addAll(libroRepositorio.buscar(criterio));
        resultados.addAll(periodicoRepositorio.buscar(criterio));
        resultados.addAll(computadorRepositorio.buscar(criterio));
        return resultados;
    }

    public List<Recurso> obtenerTodos() {
        List<Recurso> todos = new ArrayList<>();
        todos.addAll(libroRepositorio.obtenerTodos());
        todos.addAll(periodicoRepositorio.obtenerTodos());
        todos.addAll(computadorRepositorio.obtenerTodos());
        return Collections.unmodifiableList(todos);
    }
}
