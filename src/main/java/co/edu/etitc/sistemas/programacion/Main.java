package co.edu.etitc.sistemas.programacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(Main.class, args)) {

		DataSource dataSource = context.getBean(DataSource.class);

            ServicioBiblioteca biblioteca = context.getBean(ServicioBiblioteca.class);

            // Crear recursos de prueba
            Libro libro1 = new Libro( null, "Gabriel García Márquez", "Sudamericana", "1967", "Cien años de soledad", LocalDateTime.now(), true);

            Computador comp1 = new Computador(null, "Dell", "Workstation Dell", "Windows 11 Pro", "Dell", LocalDateTime.now(), true, TipoComputador.ESCRITORIO);

            Periodico per1 = new Periodico(null, LocalDate.of(2023, 10, 20), "El espectador", "Casa Editorial El Espectador", LocalDateTime.now(), true);

            // Persistir recursos
            biblioteca.agregarRecurso(libro1);
            biblioteca.agregarRecurso(comp1);
            biblioteca.agregarRecurso(per1);

            // Buscar todos los recursos
            System.out.println("\n=== Recursos iniciales ===");
            biblioteca.obtenerTodos().forEach(System.out::println);

            // Búsqueda por criterio
            String criterio = "Dell";
            System.out.println("\nBuscando: " + criterio);
            biblioteca.buscaRecursos(criterio).forEach(recurso -> {
                System.out.println("Encontrado: " + recurso);
                System.out.println("Eliminando...");
                biblioteca.eliminarRecurso(recurso);
            });

            // Resultado final
            System.out.println("\n=== Recursos restantes ===");
            biblioteca.obtenerTodos().forEach(System.out::println);
        }
    }

}