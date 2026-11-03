# Examen — CRUD de libros en tres capas

**Estudiante:** Aelajandro Camacho

API REST con Spring Boot para consultar el catálogo de la biblioteca «Palabras». Los datos viven en una lista en memoria, sin base de datos ni JPA.

## Requisitos

- Java 21 o superior
- Maven (o el wrapper `./mvnw` generado por Spring Initializr)

## Cómo ejecutar

```bash
./mvnw spring-boot:run
```

La aplicación queda en `http://localhost:8080`.

## Estructura

```
com.biblioteca
├── BibliotecaApplication
├── presentacion   → ControladorLibros
├── negocio        → Libro, RepositorioLibros (interfaz), ServicioLibros
└── persistencia   → RepositorioLibrosEnMemoria
```

Dependencias: presentación → negocio ← persistencia. El servicio depende de la interfaz `RepositorioLibros`, y la inyección es por constructor.

## Endpoints

| Método | Ruta | Respuesta |
|--------|------|-----------|
| GET | `/libros` | 200 y arreglo con 5 libros |
| GET | `/libros/{id}` | 200 y el libro |
| GET | `/libros/{id}` inexistente | 500 (`NoSuchElementException: No existe el libro {id}`) |

## Evidencia de pruebas

### 1. `curl -i http://localhost:8080/libros`
![listar](capturas/01-listar.png)

### 2. `curl -i http://localhost:8080/libros/1`
![libro 1](capturas/02-libro-1.png)

### 3. `curl -i http://localhost:8080/libros/4`
![libro 4](capturas/03-libro-4.png)

### 4. `curl -i http://localhost:8080/libros/99`
![libro 99](capturas/04-libro-99-error-500.png)
