package co.edu.etitc.sistemas.programacion;

import co.edu.etitc.sistemas.programacion.ejemplo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Aplicacion {

    private final EjemploPractico ejemploPractico;

    @Autowired
    public Aplicacion(EjemploPractico ejemploPractico) {
        this.ejemploPractico = ejemploPractico;
    }

    public void ejecutar() {
        System.out.println(ejemploPractico.enviarMensaje("Prueba"));
    }
}