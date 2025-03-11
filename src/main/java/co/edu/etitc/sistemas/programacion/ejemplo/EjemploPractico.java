package co.edu.etitc.sistemas.programacion.ejemplo;

import org.springframework.stereotype.Service;

@Service
public class EjemploPractico {

    public String enviarMensaje(String destinatario) {
        return "Mensaje prueba: " + destinatario;
    }
}