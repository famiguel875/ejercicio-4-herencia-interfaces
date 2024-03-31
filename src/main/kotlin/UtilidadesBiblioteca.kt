import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Clase de utilidades para la biblioteca.
 */
object UtilidadesBiblioteca {
    private var contadorLibros = 1 // Contador para generar identificadores únicos

    /**
     * Genera un identificador único para un libro.
     * @return El identificador único generado.
     */
    fun generarIdentificadorUnico(): String {
        // Se puede combinar la fecha y hora actual con un contador para obtener un identificador único
        val fechaHoraActual = LocalDateTime.now()
        val formato = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")
        val fechaHoraFormateada = fechaHoraActual.format(formato)
        return "L$fechaHoraFormateada${contadorLibros++}"
    }
}