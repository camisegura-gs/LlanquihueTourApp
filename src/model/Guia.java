package model;

/**
 * Representa a un guía u operador vinculado a la operación de Llanquihue Tour.
 */
public class Guia {
    private String rut;
    private String nombre;
    private String especialidad;

    public Guia() {
    }

    public Guia(String rut, String nombre, String especialidad) {
        this.rut = rut;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Esp.: %s", nombre, rut, especialidad);
    }
}