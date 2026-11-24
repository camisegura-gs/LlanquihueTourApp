# LlanquihueTourApp

## Descripción
Aplicación en Java desarrollada para **Llanquihue Tour**, encargada de leer información turística desde un archivo externo de texto plano (`.txt`), procesarla mediante la separación de cadenas con `.split(";")`, almacenarla en una colección dinámica (`ArrayList`) y mostrar recorridos y filtros en consola.

## Estructura de Paquetes y Carpetas
* `model/`: Contiene la clase `Tour` con sus atributos, constructores, getters, setters y `toString()`.
* `data/`: Contiene la clase `GestorDatos` encargada de la lectura del archivo y el parseo de datos.
* `ui/`: Contiene la clase `Main` que ejecuta la interfaz de consola y aplica los filtros de negocio.
* `resources/`: Almacena el archivo plano `tours.txt`.

## Instrucciones para Ejecutar
1. Clonar o descargar el repositorio.
2. Abrir el proyecto en IntelliJ IDEA.
3. Asegurarse de que el archivo `tours.txt` esté ubicado en la carpeta `resources/`.
4. Ejecutar la clase `Main.java` ubicada en el paquete `ui`.
