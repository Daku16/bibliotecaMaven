package co.edu.etitc.sistemas.programacion;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "PERIODICO")
public class Periodico implements Recurso {

    @Id
    private Integer id;
    @Column("FECHA_PUBLICACION")
    private LocalDate fechaPublicacion;
    private String editorial;
    private String nombre;
    @Column("FECHA_INGRESO")
    private LocalDateTime fechaIngreso;
    private boolean activo;

    public Periodico(Integer id, LocalDate fechaPublicacion, String nombre, String editorial, LocalDateTime fechaIngreso, boolean activo) {
        this.id = id;
        this.fechaPublicacion = fechaPublicacion;
        this.nombre = nombre;
        this.editorial = editorial;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public Periodico() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public LocalDateTime getFechaIngreso() {
        return this.fechaIngreso;
    }

    @Override
    public boolean isActivo() {
        return this.activo;
    }

    @Override
    public void darDeBaja() {
        this.activo = false;
    }

    @Override
    public String toString() {
        return "Periodico{" +
                "id=" + id +
                ", fechaPublicacion=" + fechaPublicacion +
                ", editorial='" + editorial + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", activo=" + activo +
                '}';
    }
}
