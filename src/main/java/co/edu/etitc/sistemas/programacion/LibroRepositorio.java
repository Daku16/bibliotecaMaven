package co.edu.etitc.sistemas.programacion;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class LibroRepositorio implements Repositorio<Libro> {

    private final List<Libro> libros = new ArrayList<>();

    @Override
    public void agregar(Libro libro) {
        libros.add(libro);
    }

    @Override
    public void eliminar(Libro libro) {
        libros.remove(libro);
    }

    @Override
    public Collection<Libro> buscar(String criterio) {
        return libros.stream()
                .filter(l -> l.getNombre().contains(criterio)
                        || l.getAutor().contains(criterio)
                        || l.getEditorial().contains(criterio)
                        || String.valueOf(l.getAnio()).contains(criterio))
                .toList();
    }

    @Override
    public Collection<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }
}