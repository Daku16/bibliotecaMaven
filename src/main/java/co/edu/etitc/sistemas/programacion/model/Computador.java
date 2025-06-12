package co.edu.etitc.sistemas.programacion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(name = "COMPUTADOR")
public class Computador implements Recurso {

    @Id
    private Integer id;
    private String marca;
    private String modelo;
    private String sistemaOperativo;
    private String nombre;
    @Column("FECHA_INGRESO")
    private LocalDateTime fechaIngreso;
    private boolean activo;
    @Column("TIPO_COMPUTADOR")
    private TipoComputador tipoComputador;

    public Computador(Integer id, String marca, String modelo, String sistemaOperativo, String nombre, LocalDateTime fechaIngreso, boolean activo, TipoComputador tipoComputador) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.activo = activo;
        this.tipoComputador = tipoComputador;
    }

    public Computador() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
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

    public TipoComputador getTipoComputador() {
        return tipoComputador;
    }

    public void setTipoComputador(TipoComputador tipoComputador) {
        this.tipoComputador = tipoComputador;
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
        return "Computador{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", activo=" + activo +
                ", tipoComputador=" + tipoComputador +
                '}';
    }
}
