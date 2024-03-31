/**
 * Clase que representa un DVD en la biblioteca.
 * @property[id] El identificador único del DVD.
 * @property[titulo] El título del DVD.
 * @property[duracion] La duración del DVD en minutos.
 * @property[genero] El género del DVD.
 * @property[estado] El estado del DVD (disponible o prestado).
 */
class DVD(
    id: String,
    titulo: String,
    val duracion: Int,
    val genero: String,
    estado: EstadoElemento = EstadoElemento.DISPONIBLE
) : ElementoBiblioteca(id, titulo, estado), Prestable {
    /**
     * Permite prestar el DVD.
     */
    override fun prestar() {
        if (estado == EstadoElemento.DISPONIBLE) {
            estado = EstadoElemento.PRESTADO
            GestorMensajes.log("DVD prestado: $titulo")
        } else {
            GestorMensajes.error("El DVD $titulo no está disponible para préstamo.")
        }
    }

    /**
     * Permite devolver el DVD.
     */
    override fun devolver() {
        if (estado == EstadoElemento.PRESTADO) {
            estado = EstadoElemento.DISPONIBLE
            GestorMensajes.log("DVD devuelto: $titulo")
        } else {
            GestorMensajes.error("El DVD $titulo no estaba en préstamo.")
        }
    }
}