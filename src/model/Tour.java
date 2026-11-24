package model;

/**
 * Representa un servicio turístico ofrecido por la agencia Llanquihue Tour.
 */
public class Tour {
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int precio;
    private Guia guia; // Composición: el Tour se relaciona con un Guia

    // Constructor vacío
    public Tour() {
    }

    // Constructor sin guía (compatibilidad)
    public Tour(String nombre, String ubicacion, String tipo, int precio) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Constructor con composición de Guia
    public Tour(String nombre, String ubicacion, String tipo, int precio, Guia guia) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
        this.guia = guia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Guia getGuia() {
        return guia;
    }

    public void setGuia(Guia guia) {
        this.guia = guia;
    }

    @Override
    public String toString() {
        String infoGuia = (guia != null) ? guia.toString() : "Sin guía asignado";
        return String.format("Tour: %-26s | Ubicación: %-14s | Tipo: %-12s | Precio: $%,d | Guía: %s",
                nombre, ubicacion, tipo, precio, infoGuia);
    }
}