package data;

import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Encargada de leer el archivo externo y transformar los datos en objetos Java.
 */
public class GestorDatos {

    public ArrayList<Tour> cargarTours(String rutaArchivo) {
        ArrayList<Tour> listaTours = new ArrayList<>();

        // BufferedReader para lectura eficiente línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Omitir líneas vacías por seguridad
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Separar los campos usando el punto y coma
                String[] datos = linea.split(";");

                if (datos.length == 4) {
                    String nombre = datos[0].trim();
                    String ubicacion = datos[1].trim();
                    String tipo = datos[2].trim();
                    int precio = Integer.parseInt(datos[3].trim());

                    // Instanciar y agregar a la colección dinámica
                    Tour tour = new Tour(nombre, ubicacion, tipo, precio);
                    listaTours.add(tour);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir el precio a número: " + e.getMessage());
        }

        return listaTours;
    }
}