package ui;

import data.GestorDatos;
import model.Tour;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();
        String ruta = "resources/tours.txt";

        // Cargar datos desde el archivo hacia el ArrayList
        ArrayList<Tour> catalogo = gestor.cargarTours(ruta);

        System.out.println("======================================================================================");
        System.out.println("                  1. RECORRIDO TOTAL - CATÁLOGO LLANQUIHUE TOUR");
        System.out.println("======================================================================================");

        if (catalogo.isEmpty()) {
            System.out.println("No se pudieron cargar los tours. Revisa la ruta del archivo.");
        } else {
            for (Tour t : catalogo) {
                System.out.println(t); // <--- Aquí corregimos strPrintln por out.println
            }
        }

        System.out.println("\n======================================================================================");
        System.out.println("             2. FILTRADO POR CONDICIÓN: TOURS GASTRONÓMICOS");
        System.out.println("======================================================================================");

        for (Tour t : catalogo) {
            if (t.getTipo().equalsIgnoreCase("Gastronomico")) {
                System.out.println(t);
            }
        }
    }
}