/**
 * Función principal que simula el funcionamiento de la biblioteca.
 */
fun main() {
    // Crear instancias de libros
    val libro1 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía")
    val libro2 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro3 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "1984", "George Orwell", 1949, "Distopía")

    // Crear instancia de gestor de biblioteca
    val gestorInventario = GestorBiblioteca()

    // Agregar libros al inventario
    gestorInventario.agregarLibro(libro1)
    gestorInventario.agregarLibro(libro2)
    gestorInventario.agregarLibro(libro3)

    // Crear instancias de usuarios
    val usuario1 = Usuario("1", "Usuario1")
    val usuario2 = Usuario("2", "Usuario2")

    // Registrar préstamos
    gestorInventario.registrarPrestamo(usuario1, libro1)
    gestorInventario.registrarPrestamo(usuario2, libro2)

    // Devolver libro
    gestorInventario.devolverLibro(libro1)

    // Consultar historial de préstamos de un libro
    gestorInventario.consultarHistorialPrestamosLibro(libro1)

    // Consultar historial de préstamos de un usuario
    gestorInventario.consultarHistorialPrestamosUsuario(usuario2)

    // Agregar libros prestados a usuarios
    usuario1.agregarLibroPrestado(libro1)
    usuario2.agregarLibroPrestado(libro2)

    // Consultar libros prestados por usuarios
    GestorMensajes.log("Libros prestados a ${usuario1.obtenerNombre()}: ${usuario1.consultarLibrosPrestados().joinToString { it.titulo }}")
    GestorMensajes.log("Libros prestados a ${usuario2.obtenerNombre()}: ${usuario2.consultarLibrosPrestados().joinToString { it.titulo }}")

    // Crear instancia del catálogo
    val generadorInformes = Catalogo(gestorInventario)

    // Generar informe detallado de todos los libros
    generadorInformes.catalogoLibrosCompleto()

    // Generar informe de los libros disponibles
    generadorInformes.catalogoLibrosDisponibles()

    // Generar informe de los libros prestados
    generadorInformes.catalogoLibrosPrestados()

    val libro4 = Libro(UtilidadesBiblioteca.generarIdentificadorUnico(), "El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía")
    val revista = Revista(UtilidadesBiblioteca.generarIdentificadorUnico(), "National Geographic", 123, "Ciencia", EstadoElemento.PRESTADO)
    val dvd = DVD(UtilidadesBiblioteca.generarIdentificadorUnico(), "Pulp Fiction", 154, "Drama")
    val libroElectronico = Libro("4", "Introducción a Kotlin", "PDF", 1024, "Educativa")

    // Crear instancia del catálogo
    val catalogo = Catalogo(GestorBiblioteca())

    // Agregar elementos al catálogo
    catalogo.agregarElemento(libro4)
    catalogo.agregarElemento(revista)
    catalogo.agregarElemento(dvd)
    catalogo.agregarElemento(libroElectronico)

    // Listar elementos del catálogo
    catalogo.listarElementos()

    // Ejemplo de préstamo y devolución de un libro
    libro4.prestar()
    libro4.devolver()

    // Ejemplo de préstamo y devolución de una revista
    revista.prestar()
    revista.devolver()

    // Ejemplo de préstamo y devolución de un DVD
    dvd.prestar()
    dvd.devolver()

    // Intento de préstamo de un libro electrónico (debería generar un error)
    libroElectronico.prestar()
    libroElectronico.prestar()
}