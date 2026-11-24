# LlanquihueTourApp

## Descripción
Aplicación en Java desarrollada para **Llanquihue Tour** (Región de Los Lagos), enfocada en apoyar la gestión operativa y turística de la agencia. El sistema lee registros desde un archivo externo de texto plano (`.txt`), valida la información, evita duplicados, aplica programación orientada a objetos con composición entre clases (`Tour` y `Guia`), almacena los objetos en una colección dinámica (`ArrayList`) y muestra recorridos, búsquedas y filtros por consola[cite: 1].

## Paquetes y Clases Implementadas
* `model`:[cite: 1, 2]
  * `Guia.java`: Representa al guía u operador vinculado a la operación, con atributos `private`, constructores, getters/setters y `toString()`[cite: 1, 2].
  * `Tour.java`: Representa el servicio turístico e integra composición mediante un atributo `Guia`, además de encapsulamiento, constructores, getters/setters y `toString()`[cite: 1, 2].
* `data`:[cite: 1, 2]
  * `GestorDatos.java`: Lee el archivo externo mediante `BufferedReader` con manejo de excepciones (`try-catch`), valida datos, evita duplicados, arma la colección `ArrayList<Tour>` y entrega métodos de búsqueda/filtrado[cite: 1].
* `ui`:[cite: 1, 2]
  * `Main.java`: Clase principal (`main`) que inicia la ejecución, recorre el catálogo completo y aplica filtros por tipo y ubicación en consola[cite: 1].
* `resources`:[cite: 1]
  * `tours.txt`: Archivo de datos externos separado por punto y coma (`;`).

## Instrucciones para Ejecutar
1. Clonar o descargar el repositorio desde GitHub[cite: 1].
2. Abrir el proyecto en **IntelliJ IDEA** (con JDK configurado)[cite: 1].
3. Verificar que el archivo `tours.txt` se encuentre en la carpeta `resources/tours.txt`[cite: 1].
4. Ejecutar el método `main` de la clase `ui.Main`[cite: 1, 2].
