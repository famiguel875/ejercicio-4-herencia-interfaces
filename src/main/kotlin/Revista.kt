/**
 * Clase que representa una revista en la biblioteca.
 * @param id El identificador único de la revista.
 * @param titulo El título de la revista.
 * @param edicion El número de edición de la revista.
 * @param tematica La temática de la revista.
 * @param estado El estado de disponibilidad de la revista.
 * @constructor Crea una instancia de Revista.*/
class Revista(
    id: String,
    titulo: String,
    private val edicion: Int,
    private val tematica: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {

    /**
     * Función para prestar la revista.
     */
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("Revista prestada: $titulo")
        } else {
            GestorMensajes.error("La revista $titulo no está disponible para préstamo.")
        }
    }

    /**
     * Función para devolver la revista.
     */
    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("Revista devuelta: $titulo")
        } else {
            GestorMensajes.error("La revista $titulo no estaba en préstamo.")
        }
    }
}