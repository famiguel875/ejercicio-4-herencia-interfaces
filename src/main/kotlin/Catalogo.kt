/**
 * Clase que representa el catálogo de la biblioteca, permitiendo la gestión y consulta de elementos bibliográficos.
 * @property[inventario] El gestor de biblioteca que contiene el inventario de libros.
 */
class Catalogo(private val inventario: GestorBiblioteca) {
    /**
     * Genera un informe detallado completo de todos los libros en la biblioteca.
     */
    fun catalogoLibrosCompleto() {
        GestorMensajes.log("\nInforme Detallado Completo de la Biblioteca:")
        inventario.listarTodosLosLibros().forEach { libro ->
            GestorMensajes.log("- ${libro.titulo} (UUID: ${libro.id}) - Titulo: ${libro.titulo} - Autor: ${libro.autor} - Año de publicación: ${libro.anioPublicacion} - Tematica: ${libro.tematica} - Estado: ${libro.estado}")
        }
    }

    /**
     * Genera un informe de los libros disponibles para préstamo en la biblioteca.
     */
    fun catalogoLibrosDisponibles() {
        GestorMensajes.log("\nInforme de Libros Disponibles para Préstamo:")
        inventario.listarLibrosDisponibles().forEach { libro ->
            GestorMensajes.log("- ${libro.titulo} (UUID: ${libro.id}) - Titulo: ${libro.titulo} - Autor: ${libro.autor} - Año de publicación: ${libro.anioPublicacion} - Tematica: ${libro.tematica} - Estado: ${libro.estado}")
        }
    }

    /**
     * Genera un informe de los libros actualmente prestados en la biblioteca.
     */
    fun catalogoLibrosPrestados() {
        GestorMensajes.log("\nInforme de Libros Actualmente Prestados:")
        inventario.listarLibrosPrestados().forEach { libro ->
            GestorMensajes.log("- ${libro.titulo} (UUID: ${libro.id}) - Titulo: ${libro.titulo} - Autor: ${libro.autor} - Año de publicación: ${libro.anioPublicacion} - Tematica: ${libro.tematica} - Estado: ${libro.estado}")
        }
    }

    private val elementos = mutableListOf<ElementoBiblioteca>()

    /**
     * Agrega un elemento al catálogo.
     * @param[elemento] El elemento a agregar.
     */
    fun agregarElemento(elemento: ElementoBiblioteca) {
        elementos.add(elemento)
        GestorMensajes.log("Elemento agregado al catálogo: ${elemento.titulo}")
    }

    /**
     * Remueve un elemento del catálogo.
     * @param[elemento] El elemento a remover.
     */
    fun removerElemento(elemento: ElementoBiblioteca) {
        elementos.remove(elemento)
        GestorMensajes.log("Elemento eliminado del catálogo: ${elemento.titulo}")
    }

    /**
     * Busca un elemento en el catálogo por su ID.
     * @param[id] El ID del elemento a buscar.
     * @return El elemento encontrado o null si no se encuentra.
     */
    fun buscarElementoPorId(id: String): ElementoBiblioteca? {
        return elementos.find { it.id == id }
    }

    /**
     * Lista todos los elementos del catálogo.
     */
    fun listarElementos() {
        GestorMensajes.log("Lista de elementos en el catálogo:")
        elementos.forEach { elemento ->
            GestorMensajes.log("- ${elemento.titulo} (ID: ${elemento.id})")
        }
    }
}