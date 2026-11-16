package model;

/**
 * Representa un servicio turístico ofrecido por la agencia Llanquihue Tour.
 */
public class Tour {
    private String nombre;
    private String ubicacion;
    private String tipo;
    private int precio;

    // Constructor vacío
    public Tour() {
    }

    // Constructor con parámetros
    public Tour(String nombre, String ubicacion, String tipo, int precio) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.precio = precio;
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return String.format("Tour: %-28s | Ubicación: %-14s | Tipo: %-13s | Precio: $%,d",
                nombre, ubicacion, tipo, precio);
    }
}