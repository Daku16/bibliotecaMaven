package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public interface Recurso {
    public String getNombre();
    public LocalDateTime getFechaIngreso();
    public boolean isActivo();
    public void darDeBaja();
    public String toString();

}