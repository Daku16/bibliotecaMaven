package co.edu.etitc.sistemas.programacion;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ServicioBiblioteca {

    private List<Recurso> biblioteca;
    public ServicioBiblioteca(){
        this.biblioteca=new ArrayList<>();
    }
    public void agregarRecurso(Recurso recurso){
        biblioteca.add(recurso);
    }

    public void eliminarRecurso(Recurso recurso){
        biblioteca.remove(recurso);
    }
    public List<Recurso> buscaRecursos (String criterio){
        return biblioteca.stream().filter(r ->r.coincideConCriterio(criterio)).collect(Collectors.toList());
    }
    public List<Recurso> obtenRecursos(){
        return new ArrayList<>(biblioteca);
    }

   

    

}
