package co.edu.etitc.sistemas.programacion.repositories;

import co.edu.etitc.sistemas.programacion.model.Recurso;

import java.util.Collection;

public interface RecursoRepositorio<T extends Recurso> {
    void agregar(T recurso);

    void eliminar(T recurso);

    Collection<T> buscar(String criterio);

    Collection<T> obtenerTodos();
}
