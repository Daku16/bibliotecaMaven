package co.edu.etitc.sistemas.programacion;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InicioAplicacion implements InitializingBean {

    @Value("${app.name}")
    private String nombreApp;

    @Override
    public void afterPropertiesSet() {
        System.out.println("\n=== Aplicación iniciada ===");
        System.out.println("Nombre: " + nombreApp);
    }
}