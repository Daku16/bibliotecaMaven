package co.edu.etitc.sistemas.programacion;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainEjemplo {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Aplicacion app = context.getBean(Aplicacion.class);
            app.ejecutar();
        }
    }
}