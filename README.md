# 🎬 ScreenMatch - Java con Programación Orientada a Objetos
Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar y calificar películas y series. Implementa principios de Programación Orientada a Objetos (POO) como encapsulamiento, herencia y polimorfismo.​

## 🚀 Características Principales
- Modelado de Medios: Clases para representar películas y series con atributos como título, duración y año de lanzamiento.

- Calificaciones: Funcionalidad para calificar películas y series, calculando promedios y mostrando estadísticas.

- Listas de Recomendaciones: Gestión de listas de medios recomendados, con la capacidad de agregar y mostrar contenido.

- Interfaz de Usuario: Menú interactivo en consola para navegar por las diferentes funcionalidades.​

## 🧠 Tecnologías y Conceptos Utilizados
- Java 17+

- Programación Orientada a Objetos (POO): Encapsulamiento, herencia, polimorfismo.

- Colecciones: Uso de ArrayList para manejar listas de medios.

- Control de Flujo: Estructuras como if, switch, for y while.​

## 📁 Estructura del Proyecto
```css
screenMatch-POO-Java/
├── src/
│   ├── model/
│   │   ├── Pelicula.java
│   │   ├── Serie.java
│   │   └── Titulo.java
│   ├── principal/
│   │   └── com.aluracursos.screenmatch.principal.Principal.java
│   └── util/
│       └── CalculadoraDeTiempo.java
├── README.md
└── .gitignore
```
## 🛠️ Instrucciones de Ejecución
1. Clonar el repositorio:

```bash
git clone https://github.com/alonso1298/screenMatch-POO-Java.git
cd screenMatch-POO-Java
```
2. Compilar el proyecto:

``` bash
javac src/principal/com.aluracursos.screenmatch.principal.Principal.java
```
3. Ejecutar la aplicación:

```bash
java -cp src principal.com.aluracursos.screenmatch.principal.Principal
```

## 📄 Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.​

Desarrollado por Alonso como parte de su aprendizaje en Java y Programación Orientada a Objetos.
