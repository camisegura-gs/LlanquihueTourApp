package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

/**
 * Clase principal que ejecuta la aplicación LlanquihueTourApp desde consola.
 */
public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();
        String ruta = "resources/tours.txt";

        // 1. Cargar datos desde el archivo hacia el ArrayList
        ArrayList<Tour> catalogo = gestor.cargarTours(ruta);

        System.out.println("======================================================================================================");
        System.out.println("                       1. RECORRIDO TOTAL - CATÁLOGO LLANQUIHUE TOUR");
        System.out.println("======================================================================================================");

        if (catalogo.isEmpty()) {
            System.out.println("No se pudieron cargar los tours. Revisa la ruta o el contenido de " + ruta);
        } else {
            for (Tour t : catalogo) {
                System.out.println(t);
            }
        }

        // 2. Filtrado por condición: tours gastronómicos
        System.out.println("\n======================================================================================================");
        System.out.println("                    2. FILTRADO POR CONDICIÓN: TOURS GASTRONÓMICOS");
        System.out.println("======================================================================================================");

        int encontradosGastronomicos = 0;
        for (Tour t : catalogo) {
            String tipoNormalizado = t.getTipo().toLowerCase().replace("ó", "o");
            if (tipoNormalizado.contains("gastronomico")) {
                System.out.println(t);
                encontradosGastronomicos++;
            }
        }
        if (encontradosGastronomicos == 0) {
            System.out.println("No se encontraron tours gastronómicos en el catálogo.");
        }

        // 3. Búsqueda / filtrado adicional por ubicación (usando método de GestorDatos)
        System.out.println("\n======================================================================================================");
        System.out.println("                 3. BÚSQUEDA POR UBICACIÓN: PUERTO VARAS");
        System.out.println("======================================================================================================");

        ArrayList<Tour> toursPuertoVaras = gestor.buscarPorUbicacion(catalogo, "Puerto Varas");
        if (toursPuertoVaras.isEmpty()) {
            System.out.println("No se encontraron tours en Puerto Varas.");
        } else {
            for (Tour t : toursPuertoVaras) {
                System.out.println(t);
            }
        }
    }
}