/**
 * Clase que gestiona el inventario de una biblioteca, incluyendo la adición, eliminación y consulta de libros,
 * así como el registro y consulta de préstamos.
 */
class GestorBiblioteca {
    private val libros = mutableListOf<Libro>()
    private val registroPrestamos = RegistroPrestamos(this)

    /**
     * Agrega un libro al inventario de la biblioteca.
     * @param libro El libro a agregar.
     */
    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        GestorMensajes.log("Libro agregado: ${libro.titulo}")
    }

    /**
     * Elimina un libro del inventario de la biblioteca.
     * @param libro El libro a eliminar.
     */
    fun removerLibro(libro: Libro) {
        libros.remove(libro)
        GestorMensajes.log("Libro removido: ${libro.titulo}")
    }

    /**
     * Cambia el estado de un libro en el inventario.
     * @param id El ID del libro cuyo estado se va a cambiar.
     * @param nuevoEstado El nuevo estado del libro.
     */
    fun cambiarEstadoLibro(id: String, nuevoEstado: EstadoElemento) {
        libros.find { it.id == id }?.let {
            it.estado = nuevoEstado
            GestorMensajes.log("Estado cambiado a $nuevoEstado para el libro: ${it.titulo}")
        }
    }

    /**
     * Verifica si un libro con el ID especificado está disponible para préstamo.
     * @param id El ID del libro a verificar.
     * @return true si el libro está disponible para préstamo, false de lo contrario.
     */
    fun estaDisponible(id: String): Boolean {
        return libros.any { it.id == id && it.estado == EstadoElemento.DISPONIBLE }
    }

    /**
     * Verifica si un libro con el ID especificado está actualmente prestado.
     * @param id El ID del libro a verificar.
     * @return true si el libro está prestado, false de lo contrario.
     */
    fun estaPrestado(id: String): Boolean {
        return libros.any { it.id == id && it.estado == EstadoElemento.PRESTADO }
    }

    /**
     * Lista todos los libros en el inventario.
     * @return Lista de todos los libros en el inventario.
     */
    fun listarTodosLosLibros(): List<Libro> = libros

    /**
     * Lista todos los libros disponibles para préstamo.
     * @return Lista de libros disponibles para préstamo.
     */
    fun listarLibrosDisponibles(): List<Libro> = libros.filter { it.estado == EstadoElemento.DISPONIBLE }

    /**
     * Lista todos los libros actualmente prestados.
     * @return Lista de libros prestados.
     */
    fun listarLibrosPrestados(): List<Libro> = libros.filter { it.estado == EstadoElemento.PRESTADO }

    /**
     * Registra un préstamo de libro para un usuario dado.
     * @param usuario El usuario que realiza el préstamo.
     * @param libro El libro prestado.
     */
    fun registrarPrestamo(usuario: Usuario, libro: Libro) {
        registroPrestamos.registrarPrestamo(usuario, libro)
    }

    /**
     * Devuelve un libro prestado al inventario.
     * @param libro El libro a devolver.
     */
    fun devolverLibro(libro: Libro) {
        registroPrestamos.devolverLibro(libro)
    }

    /**
     * Consulta el historial de préstamos de un libro específico.
     * @param libro El libro del cual se desea consultar el historial.
     */
    fun consultarHistorialPrestamosLibro(libro: Libro) {
        registroPrestamos.consultarHistorialPrestamosLibro(libro)
    }

    /**
     * Consulta el historial de préstamos realizados por un usuario específico.
     * @param usuario El usuario del cual se desea consultar el historial de préstamos.
     */
    fun consultarHistorialPrestamosUsuario(usuario: Usuario) {
        registroPrestamos.consultarHistorialPrestamosUsuario(usuario)
    }
}