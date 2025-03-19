package co.edu.etitc.sistemas.programacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class PeriodicoRepositorio implements RecursoRepositorio<Periodico> {

    private final List<Periodico> periodicos = new ArrayList<>();

    @Override
    public void agregar(Periodico periodico) {
        periodicos.add(periodico);
    }

    @Override
    public void eliminar(Periodico periodico) {
        periodicos.remove(periodico);
    }

    @Override
    public Collection<Periodico> buscar(String criterio) {
        return periodicos.stream()
                .filter(periodico -> periodico.coincideConCriterio(criterio))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Periodico> obtenerTodos() {
        return new ArrayList<>(periodicos);
    }
}