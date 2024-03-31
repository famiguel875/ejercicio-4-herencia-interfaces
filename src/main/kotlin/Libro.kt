/**
 * Representa un libro en la biblioteca.
 * @property id El ID del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPublicacion El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado del libro (DISPONIBLE o PRESTADO).
 */
class Libro(
    id: String,
    titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {
    /**
     * Presta el libro.
     */
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("Libro prestado: $titulo")
        } else {
            GestorMensajes.error("El libro $titulo no está disponible para préstamo.")
        }
    }

    /**
     * Devuelve el libro.
     */
    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("Libro devuelto: $titulo")
        } else {
            GestorMensajes.error("El libro $titulo no estaba en préstamo.")
        }
    }

    init {
        require(titulo.isNotEmpty()) { "El libro debe tener titulo" }
        require(autor.isNotEmpty()) { "El libro debe tener autor" }
        require(anioPublicacion > 0) { "El año de publicación debe ser mayor a 0" }
        require(tematica.isNotEmpty()) { "El libro debe tener tematica" }
    }
}