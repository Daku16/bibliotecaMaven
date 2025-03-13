package co.edu.etitc.sistemas.programacion;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("co.edu.etitc.sistemas.programacion")
public class AppConfig {

}