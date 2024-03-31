import java.time.LocalDateTime

/**
 * Representa un préstamo de un libro.
 * @property usuario El usuario que realiza el préstamo.
 * @property libro El libro prestado.
 * @property fechaPrestamo La fecha en la que se realizó el préstamo.
 */
data class Prestamo(val usuario: Usuario, val libro: Libro, val fechaPrestamo: String = LocalDateTime.now().toString())