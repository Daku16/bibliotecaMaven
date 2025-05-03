package co.edu.etitc.sistemas.programacion;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "LIBRO")
public class Libro implements Recurso {

    @Id
    private Integer id;
    private String autor;
    private String editorial;
    private String anio;
    private String nombre;
    @Column("FECHA_INGRESO")
    private LocalDateTime fechaIngreso;
    private boolean activo;

    public Libro(Integer id, String autor, String editorial, String anio, String nombre, LocalDateTime fechaIngreso, boolean activo) {
        this.id = id;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
    }

    public Libro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
        return "Libro{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anio='" + anio + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", activo=" + activo +
                '}';
    }
}
