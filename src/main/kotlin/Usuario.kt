/**
 * Representa un usuario de la biblioteca.
 * @property id El ID del usuario.
 * @property nombre El nombre del usuario.
 */

class Usuario(private val id: String, private val nombre: String) {
    private val librosPrestados = mutableListOf<Libro>()

    /**
     * Agrega un libro prestado al usuario.
     * @param libro El libro prestado.
     */
    fun agregarLibroPrestado(libro: Libro) {
        librosPrestados.add(libro)
    }

    /**
     * Quita un libro prestado del usuario.
     * @param libro El libro a devolver.
     */
    fun quitarLibroPrestado(libro: Libro) {
        librosPrestados.remove(libro)
    }

    /**
     * Consulta los libros prestados por el usuario.
     * @return La lista de libros prestados.
     */
    fun consultarLibrosPrestados(): List<Libro> {
        return librosPrestados.toList()
    }

    /**
     * Obtiene el ID del usuario.
     * @return El ID del usuario.
     */
    fun obtenerId(): String {
        return id
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    fun obtenerNombre(): String {
        return nombre
    }
}