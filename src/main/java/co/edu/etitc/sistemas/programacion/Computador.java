package co.edu.etitc.sistemas.programacion;

import java.time.LocalDateTime;

public class Computador extends Recurso {

    private String marca;
    private String modelo;
    private String sistemaOperativo;

    public Computador(String marca, String modelo, String sistemaOperativo, boolean activo, LocalDateTime fechaIngreso,
            String nombre) {
        super(activo, fechaIngreso, nombre);
        this.marca = marca;
        this.modelo = modelo;
        this.sistemaOperativo = sistemaOperativo;
    }

    @Override
    public boolean coincideConCriterio(String criterio) {
        return super.coincideConCriterio(criterio) || marca.contains(criterio) || modelo.contains(criterio)
                || sistemaOperativo.contains(criterio);
    }

    @Override
    public String toString() {
        return "Computador: " + this.getNombre() + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "SistemaOperativo: " + sistemaOperativo + "\n" +
                " ";
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

}
