package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class ComputadorRepositorios implements RecursoRepositorio<Computador> {

    private final List<Computador> computadores = new ArrayList<>();

    @Override
    public void agregar(Computador computador) {
        computadores.add(computador);
    }

    @Override
    public void eliminar(Computador computador) {
        computadores.remove(computador);
    }

    @Override
    public Collection<Computador> buscar(String criterio) {
        return computadores.stream()
                .filter(p -> p.getNombre().contains(criterio)
                        || p.getMarca().contains(criterio)
                        || p.getModelo().contains(criterio)
                        || p.getSistemaOperativo().contains(criterio))
                .toList();
    }

    @Override
    public Collection<Computador> obtenerTodos() {
        return new ArrayList<>(computadores);
    }
}