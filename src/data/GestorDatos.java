package data;

import model.Guia;
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Encargada de leer el archivo externo, validar registros, armar objetos
 * y realizar búsquedas/filtros sobre la colección de tours.
 */
public class GestorDatos {

    public ArrayList<Tour> cargarTours(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(";");

                if (datos.length < 4) {
                    System.err.println("Línea " + numeroLinea + " omitida: formato incompleto (" + linea + ")");
                    continue;
                }

                try {
                    String nombre = datos[0].trim();
                    String ubicacion = datos[1].trim();
                    String tipo = datos[2].trim();
                    int precio = Integer.parseInt(datos[3].trim());

                    // Validaciones básicas de negocio
                    if (nombre.isEmpty() || ubicacion.isEmpty() || tipo.isEmpty()) {
                        System.err.println("Línea " + numeroLinea + " omitida: campos de texto vacíos.");
                        continue;
                    }
                    if (precio <= 0) {
                        System.err.println("Línea " + numeroLinea + " omitida: el precio debe ser mayor a 0.");
                        continue;
                    }

                    // Evitar duplicados por nombre y ubicación (ignorando mayúsculas/minúsculas)
                    if (existeTourDuplicado(listaTours, nombre, ubicacion)) {
                        System.out.println("Aviso: Tour duplicado omitido -> " + nombre + " (" + ubicacion + ")");
                        continue;
                    }

                    // Composición: crear Guia si vienen los datos en el archivo, o asignar uno base
                    Guia guiaAsignado;
                    if (datos.length >= 7) {
                        String rutGuia = datos[4].trim();
                        String nombreGuia = datos[5].trim();
                        String especialidad = datos[6].trim();
                        guiaAsignado = new Guia(rutGuia, nombreGuia, especialidad);
                    } else {
                        guiaAsignado = new Guia("Sin-RUT", "Por asignar", "General");
                    }

                    Tour tour = new Tour(nombre, ubicacion, tipo, precio, guiaAsignado);
                    listaTours.add(tour);

                } catch (NumberFormatException e) {
                    System.err.println("Error en línea " + numeroLinea + " al convertir el precio a número: " + datos[3].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo '" + rutaArchivo + "': " + e.getMessage());
        }

        return listaTours;
    }

    // Verifica si ya existe un tour con el mismo nombre y ubicación
    private boolean existeTourDuplicado(ArrayList<Tour> listaTours, String nombre, String ubicacion) {
        for (Tour t : listaTours) {
            if (t.getNombre().equalsIgnoreCase(nombre) && t.getUbicacion().equalsIgnoreCase(ubicacion)) {
                return true;
            }
        }
        return false;
    }

    // Filtro simple por ubicación o tipo (búsqueda parcial sin distinguir mayúsculas)
    public ArrayList<Tour> buscarPorUbicacion(ArrayList<Tour> listaTours, String ubicacionBuscada) {
        ArrayList<Tour> resultados = new ArrayList<>();
        if (listaTours == null || ubicacionBuscada == null || ubicacionBuscada.trim().isEmpty()) {
            return resultados;
        }

        String criterio = ubicacionBuscada.trim().toLowerCase();
        for (Tour t : listaTours) {
            if (t.getUbicacion() != null && t.getUbicacion().toLowerCase().contains(criterio)) {
                resultados.add(t);
            }
        }
        return resultados;
    }

    // Filtro simple por tipo de tour
    public ArrayList<Tour> buscarPorTipo(ArrayList<Tour> listaTours, String tipoBuscado) {
        ArrayList<Tour> resultados = new ArrayList<>();
        if (listaTours == null || tipoBuscado == null || tipoBuscado.trim().isEmpty()) {
            return resultados;
        }

        String criterio = tipoBuscado.trim().toLowerCase();
        for (Tour t : listaTours) {
            if (t.getTipo() != null && t.getTipo().toLowerCase().contains(criterio)) {
                resultados.add(t);
            }
        }
        return resultados;
    }
}