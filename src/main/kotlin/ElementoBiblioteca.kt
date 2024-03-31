/**
 * Clase abstracta que representa un elemento bibliográfico en la biblioteca.
 * @property[id] El identificador único del elemento.
 * @property[titulo] El título del elemento.
 * @property[estado] El estado del elemento (disponible o prestado).
 */
abstract class ElementoBiblioteca(
    val id: String,
    val titulo: String,
    var estado: EstadoElemento = EstadoElemento.DISPONIBLE
)