package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        ServicioBiblioteca biblioteca = new ServicioBiblioteca();

        biblioteca.agregarRecurso(new Libro("1984", LocalDateTime.now(), true, "George Orwell","Blanco y negro SAS", "1949"));
        biblioteca.agregarRecurso(new Libro("Habitos atomicos", LocalDateTime.now(), true, "James Clear","Paidos", "2018"));
        biblioteca.agregarRecurso(new Libro("Colombia una nacion a pesar de si misma", LocalDateTime.now(), true, "David Bushnell","Critica", "1996"));

        biblioteca.agregarRecurso(new Periodico("El Tiempo", LocalDate.of(2023, 10, 15), true, LocalDateTime.now(), "El Tiempo"));
        biblioteca.agregarRecurso(new Periodico("El Espectador", LocalDate.of(2023, 10, 10), true, LocalDateTime.now(), "El Espectador"));
        biblioteca.agregarRecurso(new Periodico("La República", LocalDate.of(2023, 10, 5), false, LocalDateTime.now(), "La República"));

        biblioteca.agregarRecurso(new Computador("Apple", "MacBook Pro", "macOS", true, LocalDateTime.now(), "MacBook Pro 2023"));
        biblioteca.agregarRecurso(new Computador("Dell", "XPS 13", "Windows 11", true, LocalDateTime.now(), "Dell XPS 13"));
        biblioteca.agregarRecurso(new Computador("Lenovo", "ThinkPad X1 Carbon", "Ubuntu 22.04", false, LocalDateTime.now(), "Lenovo ThinkPad"));

        System.out.println("Lista de recursos en la biblioteca:");
        biblioteca.obtenRecursos().forEach(System.out::println);
 
        String criterio = "Apple";
        System.out.println("\nRecursos que coinciden con el criterio \"" + criterio + "\":");
        biblioteca.buscaRecursos(criterio).forEach(System.out::println);
 
        if (!biblioteca.buscaRecursos(criterio).isEmpty()) {
            Recurso recursoAEliminar = biblioteca.buscaRecursos(criterio).get(0);
            biblioteca.eliminarRecurso(recursoAEliminar);
            System.out.println("\nSe eliminó el recurso: " + recursoAEliminar.getNombre());
        }
 
       System.out.println("\nLista de recursos después de la eliminación:");
       biblioteca.obtenRecursos().forEach(System.out::println);
    }


    
}
