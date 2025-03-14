package co.edu.etitc.sistemas.programacion;

import java.util.Collection;

public interface RecursoRepositorio<T extends Recurso> {
    void agregar(T recurso);

    void eliminar(T recurso);

    Collection<T> buscar(String criterio);

    Collection<T> obtenerTodos();
}
