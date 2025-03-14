package co.edu.etitc.sistemas.programacion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("co.edu.etitc.sistemas.programacion")
public class AppConfig {

    @Bean
    public ComputadorRepositorios computadorRepositorio() {
        return new ComputadorRepositorios();
    }

    @Bean
    public LibroRepositorio libroRepositorio() {
        return new LibroRepositorio();
    }

    @Bean
    public PeriodicoRepositorio periodicoRepositorio() {
        return new PeriodicoRepositorio();
    }

}