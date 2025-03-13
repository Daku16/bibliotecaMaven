package co.edu.etitc.sistemas.programacion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
        public static void main(String[] args) {

                try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
                        ServicioBiblioteca biblioteca = context.getBean(ServicioBiblioteca.class);

                        biblioteca.agregarRecurso(
                                        new Libro("1984", LocalDateTime.now(), true, "George Orwell",
                                                        "Blanco y negro SAS", "1949"));
                        biblioteca.agregarRecurso(
                                        new Libro("Habitos atomicos", LocalDateTime.now(), true, "James Clear",
                                                        "Paidos", "2018"));
                        biblioteca.agregarRecurso(
                                        new Libro("Colombia una nacion a pesar de si misma", LocalDateTime.now(), true,
                                                        "David Bushnell", "Critica", "1996"));

                        biblioteca.agregarRecurso(
                                        new Periodico("El Tiempo", LocalDate.of(2023, 10, 15), true,
                                                        LocalDateTime.now(), "El Tiempo"));
                        biblioteca.agregarRecurso(new Periodico("El Espectador", LocalDate.of(2023, 10, 10), true,
                                        LocalDateTime.now(), "El Espectador"));
                        biblioteca.agregarRecurso(new Periodico("La República", LocalDate.of(2023, 10, 5), false,
                                        LocalDateTime.now(), "La República"));

                        biblioteca.agregarRecurso(
                                        new Computador("Apple", "MacBook Pro", "macOS", true, LocalDateTime.now(),
                                                        "MacBook Pro 2023"));
                        biblioteca.agregarRecurso(
                                        new Computador("Dell", "XPS 13", "Windows 11", true, LocalDateTime.now(),
                                                        "Dell XPS 13"));
                        biblioteca.agregarRecurso(new Computador("Lenovo", "ThinkPad X1 Carbon", "Ubuntu 22.04", false,
                                        LocalDateTime.now(), "Lenovo ThinkPad"));

                        System.out.println("\n=== Recursos iniciales ===");
                        imprimirRecursos(biblioteca.obtenerTodos());

                        String criterioBusqueda = "Apple";
                        System.out.println("\nBuscando recursos con criterio: '" + criterioBusqueda + "'");

                        Collection<Recurso> resultados = biblioteca.buscaRecursos(criterioBusqueda);
                        if (!resultados.isEmpty()) {
                                System.out.println("Recurso encontrado. Eliminando...");
                                resultados.forEach(biblioteca::eliminarRecurso);
                        }

                        System.out.println("\n=== Recursos después de eliminar ===");
                        imprimirRecursos(biblioteca.obtenerTodos());
                }

        }

        private static void imprimirRecursos(Collection<Recurso> recursos) {
                if (recursos.isEmpty()) {
                        System.out.println("No hay recursos registrados");
                        return;
                }

                recursos.forEach(recurso -> System.out
                                .println("- " + recurso.getClass().getSimpleName() + ": " + recurso));
        }

}
