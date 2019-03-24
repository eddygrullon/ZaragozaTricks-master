package es.usj.zaragozatricks.models;

public class Carrera {
    public String getNombreCarrera() {
        return NombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        NombreCarrera = nombreCarrera;
    }

    public String NombreCarrera;

    public Carrera(String nombreCarrera) {
        NombreCarrera = nombreCarrera;
    }
}
