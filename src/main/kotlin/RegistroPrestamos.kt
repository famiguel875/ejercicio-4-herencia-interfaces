/**
 * Clase que gestiona los registros de préstamos en la biblioteca.
 * @property gestorBiblioteca El gestor de la biblioteca asociado.
 */
class RegistroPrestamos(private val gestorBiblioteca: GestorBiblioteca) {
    private val prestamosActuales = mutableListOf<Prestamo>()
    private val historialPrestamos = mutableListOf<Prestamo>()

    /**
     * Registra un préstamo de un libro por parte de un usuario.
     * @param usuario El usuario que realiza el préstamo.
     * @param libro El libro prestado.
     */
    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        if (gestorBiblioteca.estaDisponible(libro.id)) {
            gestorBiblioteca.cambiarEstadoLibro(libro.id, EstadoElemento.PRESTADO)
            val prestamo = Prestamo(usuario, libro)
            prestamosActuales.add(prestamo)
            historialPrestamos.add(prestamo)
            GestorMensajes.log("Préstamo registrado: Usuario ${usuario.obtenerNombre()} ha tomado prestado el libro ${libro.titulo}.")
        } else {
            GestorMensajes.error("El libro ${libro.titulo} no está disponible para préstamo.")
        }
    }

    /**
     * Devuelve un libro prestado.
     * @param libro El libro a devolver.
     */
    fun devolverLibro(libro: Libro) {
        val prestamo = prestamosActuales.find { it.libro.id == libro.id }
        if (prestamo != null) {
            gestorBiblioteca.cambiarEstadoLibro(libro.id, EstadoElemento.DISPONIBLE)
            prestamosActuales.remove(prestamo)
            GestorMensajes.log("Libro ${libro.titulo} devuelto.")
        } else {
            GestorMensajes.error("El libro ${libro.titulo} no estaba en préstamo.")
        }
    }

    /**
     * Consulta el historial de préstamos de un libro.
     * @param libro El libro del cual se consulta el historial.
     */
    fun consultarHistorialPrestamosLibro(libro: Libro) {
        val historial = historialPrestamos.filter { it.libro.id == libro.id }
        if (historial.isNotEmpty()) {
            GestorMensajes.log("Historial de préstamos para el libro ${libro.titulo}:")
            historial.forEachIndexed { index, prestamo ->
                GestorMensajes.log("${index + 1}. Usuario: ${prestamo.usuario.obtenerNombre()}, Fecha: ${prestamo.fechaPrestamo}")
            }
        } else {
            GestorMensajes.log("No hay historial de préstamos para el libro ${libro.titulo}.")
        }
    }

    /**
     * Consulta el historial de préstamos de un usuario.
     * @param usuario El usuario del cual se consulta el historial.
     */
    fun consultarHistorialPrestamosUsuario(usuario: Usuario) {
        val historial = historialPrestamos.filter { it.usuario.obtenerId() == usuario.obtenerId() }
        if (historial.isNotEmpty()) {
            GestorMensajes.log("Historial de préstamos para el usuario ${usuario.obtenerNombre()}:")
            historial.forEachIndexed { index, prestamo ->
                GestorMensajes.log("${index + 1}. Libro: ${prestamo.libro.titulo}, Fecha: ${prestamo.fechaPrestamo}")
            }
        } else {
            GestorMensajes.log("No hay historial de préstamos para el usuario ${usuario.obtenerNombre()}.")
        }
    }
}